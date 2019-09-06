package com.chen1144.wheel.concurrent;

import com.chen1144.wheel.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LocalPipe<K, V> implements Pipe<K, V> {
    private Map<K, BlockingQueue<Pair<V, Semaphore>>> map;

    public LocalPipe() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public Receiver<K, V> getReceiver() {
        return key -> {
            try {
                Pair<V, Semaphore> pair = map.computeIfAbsent(key, k -> new LinkedBlockingQueue<>()).take();
                Semaphore semaphore = pair.getValue();
                if(semaphore != null){
                    semaphore.release();
                }
                return pair.getKey();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        };
    }

    @Override
    public Sender<K, V> getSender() {
        return new Sender<K, V>() {
            @Override
            public void send(K key, V value) {
                Semaphore semaphore = new Semaphore(0);
                var pair = Pair.of(value, semaphore);
                map.computeIfAbsent(key, k -> new LinkedBlockingQueue<>()).offer(pair);
                semaphore.tryAcquire();
            }

            @Override
            public void sendAsync(K key, V value) {
                map.computeIfAbsent(key, k -> new LinkedBlockingQueue<>()).offer(Pair.of(value, null));
            }
        };
    }
}
