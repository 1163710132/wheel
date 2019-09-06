package com.chen1144.wheel.server;

import com.chen1144.wheel.util.ByteList;
import com.chen1144.wheel.util.ExceptionalRunnable;
import com.chen1144.wheel.util.Exceptions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static com.chen1144.wheel.server.Constants.*;

public class HttpServer {
    private ServerSocket serverSocket;
    private InetAddress inetAddress;
    private int port;
    private HttpHandler handler;

    private HttpServer(){}

    public void start(){
        new Thread(()->{
            while (true){
                Socket socket;
                InputStream inputStream;
                OutputStream outputStream;
                try {
                    socket = serverSocket.accept();
                    inputStream = socket.getInputStream();
                    outputStream = socket.getOutputStream();
                    try {
                        sendResponse(outputStream, handler.handleRequest(readRequest(inputStream)));
                    }catch (Exception e){
                        sendResponse(outputStream, handler.handleException(e));
                    }
                }catch (IOException e){
                    throw new RuntimeException();
                }
            }
        }).start();
    }

    public static HttpRequest readRequest(InputStream inputStream) throws IOException{
        AsciiString[] firstLine = readFirstLine(inputStream);
        AsciiString method = firstLine[0];
        URI uri = URI.create(URLDecoder.decode(firstLine[1].toString(), StandardCharsets.UTF_8));
        AsciiString version = firstLine[2];
        HttpHeader header = readHeader(inputStream);
        ByteList body = new ByteList();
        {
            //try read body
            header.getHeaders()
                    .filter(entry -> entry.key.equals(Constants.TRANSFER_ENCODING))
                    .filter(entry -> entry.value.equals(Constants.CHUNKED))
                    .findAny()
                    .ifPresentOrElse(transferEncoding->{
                        //read chunked
                        Exceptions.runWithoutException(()->{
                            int chunkedSize = bytes2int(readLine(inputStream));
                            while (chunkedSize != 0){
                                byte[] chunk = readWithSize(inputStream, chunkedSize);
                                body.addAll(chunk);
                                chunkedSize = bytes2int(readLine(inputStream));
                            }
                            inputStream.skip(2);
                        });
                    }, ()->{
                        header.getHeaders()
                                .filter(entry -> entry.key.equals(Constants.CONTENT_LENGTH))
                                .findAny()
                                .ifPresent(contentLength->{
                                    Exceptions.runWithoutException(()->{
                                        body.addAll(inputStream.readNBytes(atoi(contentLength.value)));
                                    });
                                });
                    });
        }
        HttpRequest request = new HttpRequest(method, uri, version);
        request.setHeader(header);
        request.setBody(body.toArray());
        return request;
    }

    public static void sendResponse(OutputStream outputStream, HttpResponse response) throws IOException{

    }

    public static AsciiString[] readFirstLine(InputStream inputStream) throws IOException{
        byte[] line = readLine(inputStream);
        AsciiString lineString = AsciiString.valueOf(line);
        return lineString.split(NBSP);
    }

    public static HttpHeader readHeader(InputStream inputStream) throws IOException{
        return HttpHeader.PROTOTYPE.readFrom(inputStream);
    }

    public static byte[] readWithSize(InputStream inputStream, int size) throws IOException{
        byte[] buffer = new byte[size];
        int i = 0;
        while (i < size){
            int count = inputStream.read(buffer, i, size - i);
            if(count == -1){
                throw new IOException();
            }else{
                i += count;
            }
        }
        return buffer;
    }

    public static int bytes2int(byte[] bytes){
        return (bytes[0]&0xff)<<24
            | (bytes[1]&0xff)<<16
            | (bytes[2]&0xff)<<8
            | (bytes[3]&0xff);
    }

    public static byte[] int2bytes(int num){
        return new byte[] {
                (byte)((num>>24)&0xff),
                (byte)((num>>16)&0xff),
                (byte)((num>>8)&0xff),
                (byte)((num)&0xff)
        };
    }

    public static int atoi(AsciiString asciiString){
        return Integer.parseInt(asciiString.toString());
    }

    public static byte[] readLine(InputStream inputStream) throws IOException{
        ByteList byteList = new ByteList();
        while (true){
            int read = inputStream.read();
            if(read == -1){
                return new byte[0];
            }
            if(read == Constants.CR){
                int read2 = inputStream.read();
                if(read2 == Constants.LF){
                    return byteList.toArray();
                }
            }else{
                byteList.add((byte)read);
            }
        }
    }

    public static class Builder{
        private InetAddress address;
        private int port;
        private HttpHandler handler;

        public Builder bind(InetAddress address, int port){
            this.address = address;
            this.port = port;
            return this;
        }
        public Builder setHandler(HttpHandler handler){
            this.handler = handler;
            return this;
        }
        public HttpServer build(){
            HttpServer server = new HttpServer();
            server.inetAddress = address;
            server.port = port;
            server.serverSocket = Exceptions.callWithoutException(()->{
                ServerSocket serverSocket = new ServerSocket();
                serverSocket.bind(new InetSocketAddress(address, port));
                return serverSocket;
            });
            server.handler = handler;
            return server;
        }
    }
}
