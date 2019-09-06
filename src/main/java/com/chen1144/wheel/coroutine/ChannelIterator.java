package com.chen1144.wheel.coroutine;

import java.util.Iterator;
import java.util.Optional;

public class ChannelIterator<T> implements Iterator<T> {
    private ReadableChannel<T> channel;
    private boolean hasNext;
    private T next;
    private boolean available;

    private ChannelIterator(ReadableChannel<T> channel){
        this.channel = channel;
    }

    public static <T> Iterator<T> of(ReadableChannel<T> channel){
        return new ChannelIterator<>(channel);
    }

    private void takeIfNeeded(){
        if(!available){
            Optional<T> optional = channel.readNext();
            if(hasNext = optional.isPresent()){
                next = optional.get();
            }
            available = true;
        }
    }

    @Override
    public boolean hasNext() {
        takeIfNeeded();
        return hasNext;
    }

    @Override
    public T next() {
        takeIfNeeded();
        T val = next;
        available = false;
        return val;
    }
}
