package com.chen1144.wheel.server;

import com.chen1144.wheel.io.ReaderWriter;
import com.chen1144.wheel.util.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Stream;

public class HttpHeader {
    private List<Pair<AsciiString, AsciiString>> headers;

    public HttpHeader(){
        headers = new LinkedList<>();
    }

    public Optional<AsciiString> getHeaderValue(AsciiString header){
        for(var pair: headers){
            if(pair.getKey().equals(header)){
                return Optional.of(pair.getValue());
            }
        }
        return Optional.empty();
    }

    public void putHeader(AsciiString key, AsciiString value){
        headers.add(Pair.of(key, value));
    }

    public void putAll(HttpHeader another){
        another.getHeaders().forEach(entry -> putHeader(entry.key, entry.value));
    }

    public Optional<Pair<AsciiString, AsciiString>> removeHeader(AsciiString key){
        for(int i = 0;i < headers.size();i++){
            if(headers.get(i).key.equals(key)){
                return Optional.of(headers.remove(i));
            }
        }
        return Optional.empty();
    }

    public Stream<Pair<AsciiString, AsciiString>> getHeaders(){
        return headers.stream();
    }

    public static final Prototype PROTOTYPE = new Prototype();

    public static final class Prototype implements com.chen1144.wheel.core.Prototype<HttpHeader>, ReaderWriter<HttpHeader> {
        @Override
        public HttpHeader newInstance(Object... parameters) {
            return new HttpHeader();
        }

        @Override
        public HttpHeader readFrom(InputStream inputStream) throws IOException {
            HttpHeader header = new HttpHeader();
            while (true){
                int i = inputStream.read();
                if(i == -1){
                    return header;
                }
                if(i == '\r'){
                    if(inputStream.read() == '\n'){
                        return header;
                    }else{
                        throw new IOException();
                    }
                }
            }
        }

        @Override
        public void writeTo(OutputStream outputStream, HttpHeader value) throws IOException {
            throw new UnsupportedOperationException();
        }
    }
}
