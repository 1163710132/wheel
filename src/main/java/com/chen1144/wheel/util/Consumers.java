package com.chen1144.wheel.util;

import java.util.function.Consumer;

public class Consumers {
    public static <T extends Throwable> Consumer<T> justThrow(){
        return throwable -> {
            throw new RuntimeException(throwable);
        };
    }
}
