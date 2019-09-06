package com.chen1144.wheel.io;

import java.util.Optional;

public interface Cache<Key, Value> {
    void put(Key key, Value value);
    Optional<Value> get(Key key);
}
