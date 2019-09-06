package com.chen1144.wheel.concurrent;

import java.util.function.Consumer;

public interface Receiver<K, V> {
    V receive(K key);

    default void receiveAsync(K key, Consumer<V> consumer){
        new Thread(()->{
            consumer.accept(receive(key));
        }).start();
    }
}
