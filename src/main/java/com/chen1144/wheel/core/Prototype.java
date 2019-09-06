package com.chen1144.wheel.core;

import java.lang.reflect.Type;
import java.util.Optional;

public interface Prototype<T> extends Type {
    T newInstance(Object... parameters);
}
