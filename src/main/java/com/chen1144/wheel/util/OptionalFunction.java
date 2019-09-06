package com.chen1144.wheel.util;

import java.util.Optional;
import java.util.function.Function;

@FunctionalInterface
public interface OptionalFunction<I, O> extends Function<I, Optional<O>> {
    @Override
    Optional<O> apply(I i);

    default Function<I, O> asFunction(){
        return i->apply(i).orElse(null);
    }
}
