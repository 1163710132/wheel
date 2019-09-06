package com.chen1144.wheel.coroutine;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import io.vavr.Function1;

public interface Iterables {
    public static <T> Iterable<T> fromFunction(Function1<WritableChannel<T>, ?> function1){
        Channel<T> channel = new LockedChannel<>();
        return ()->{
            new Thread(()->{
                function1.apply(channel);
            }).start();
            return ChannelIterator.of(channel);

        };
    }
}
