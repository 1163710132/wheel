package com.chen1144.wheel.server;

import java.net.URI;

public class HttpRequest {
    private AsciiString method;
    private URI uri;
    private AsciiString version;
    private HttpHeader header;
    private byte[] body;

    public HttpRequest(AsciiString method, URI uri, AsciiString version) {
        this.method = method;
        this.uri = uri;
        this.version = version;
    }

    public AsciiString getMethod() {
        return method;
    }

    public URI getUri() {
        return uri;
    }

    public HttpHeader getHeader() {
        return header;
    }

    public AsciiString getVersion() {
        return version;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public void setHeader(HttpHeader header) {
        this.header = header;
    }
}
