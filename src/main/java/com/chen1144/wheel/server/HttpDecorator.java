package com.chen1144.wheel.server;

import java.util.function.Consumer;
import java.util.function.Function;

public interface HttpDecorator extends Function<HttpResponse, HttpResponse> {

}
