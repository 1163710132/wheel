package com.chen1144.wheel.util;

public interface Generator<T> {
    T regenerate(T reference);
    void reset();
}
