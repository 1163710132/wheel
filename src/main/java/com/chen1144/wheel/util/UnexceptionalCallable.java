package com.chen1144.wheel.util;

import java.util.concurrent.Callable;

@FunctionalInterface
public interface UnexceptionalCallable<T> extends Callable<T> {
    public T call();
    default Callable<T> toCallable(){
        return this;
    }
}
