package com.chen1144.wheel.util;

import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
public interface StreamFunction<I, O> extends Function<I, Stream<O>> {
    @Override
    Stream<O> apply(I i);
}
