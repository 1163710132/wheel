package com.chen1144.wheel.server;

public class HttpResponse {
    private AsciiString version;
    private int status;
    private AsciiString phrase;
    private HttpHeader header;
    private byte[] body;

    public HttpResponse(AsciiString version, int status, AsciiString phrase) {
        this.version = version;
        this.status = status;
        this.phrase = phrase;
    }

    public AsciiString getVersion() {
        return version;
    }

    public int getStatus() {
        return status;
    }

    public AsciiString getPhrase() {
        return phrase;
    }

    public HttpHeader getHeader() {
        return header;
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
