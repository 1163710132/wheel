package com.chen1144.wheel.coroutine;

import java.util.Iterator;
import java.util.Optional;

public interface ReadableChannel<T> {
    Optional<T> readNext();

    default Iterator<T> toIterator(){
        return ChannelIterator.of(this);
    }
}
