package com.chen1144.wheel.concurrent;

import io.vavr.concurrent.Task;

public interface Sender<K, V> {
    void send(K key, V value);

    default void sendAsync(K key, V value){
        new Thread(()->{
            send(key, value);
        }).start();
    }
}
