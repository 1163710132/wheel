package com.chen1144.wheel.server;

public interface HttpHandler {
    public HttpResponse handleRequest(HttpRequest request);
    public HttpResponse handleException(Exception exception);
}
