package com.chen1144.wheel.concurrent;

public interface Pipe<K, V> {
    Receiver<K, V> getReceiver();
    Sender<K, V> getSender();
}
