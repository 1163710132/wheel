package com.chen1144.wheel.server.decorator;

import com.chen1144.wheel.server.*;
import com.chen1144.wheel.util.ByteList;

public class ChunkedDecorator implements HttpDecorator {
    @Override
    public HttpResponse apply(HttpResponse httpResponse) {
        return httpResponse.getHeader().getHeaders()
                .filter(entry -> entry.key.equals(Constants.CONTENT_LENGTH))
                .filter(entry -> entry.value.equals(Constants.ZERO))
                .findAny()
                .map(contentLength -> {
                    httpResponse.getHeader().removeHeader(Constants.CONTENT_LENGTH);
                    httpResponse.getHeader().putHeader(Constants.TRANSFER_ENCODING, Constants.CHUNKED);
                    ByteList byteList = new ByteList();
                    byteList.addAll(HttpServer.int2bytes(HttpServer.atoi(contentLength.value)));
                    byteList.addAll(Constants.CRLF.toByteArray());
                    byteList.addAll(httpResponse.getBody());
                    byteList.addAll(Constants.CRLF.toByteArray());
                    httpResponse.setBody(byteList.toArray());
                    return httpResponse;
                })
                .orElse(httpResponse);
    }
}
