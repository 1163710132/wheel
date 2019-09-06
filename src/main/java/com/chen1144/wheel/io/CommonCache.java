package com.chen1144.wheel.io;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class CommonCache<T> implements Cache<String, T> {
    private ConcurrentHashMap<String, T> concurrentHashMap;

    public CommonCache(){
        concurrentHashMap = new ConcurrentHashMap<>();
    }

    @Override
    public void put(String s, T bytes) {
        concurrentHashMap.put(s, bytes);
    }

    @Override
    public Optional<T> get(String s) {
        return Optional.ofNullable(concurrentHashMap.get(s));
    }
}
