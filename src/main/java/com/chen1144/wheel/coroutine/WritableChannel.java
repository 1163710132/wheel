package com.chen1144.wheel.coroutine;

public interface WritableChannel<T> {
    void ret(T value);
    void brk();
}
