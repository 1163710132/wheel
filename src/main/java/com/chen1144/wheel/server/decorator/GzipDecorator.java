package com.chen1144.wheel.server.decorator;

import com.chen1144.wheel.server.HttpDecorator;
import com.chen1144.wheel.server.HttpResponse;

public class GzipDecorator implements HttpDecorator {
    @Override
    public HttpResponse apply(HttpResponse httpResponse) {
        return httpResponse;
    }
}
