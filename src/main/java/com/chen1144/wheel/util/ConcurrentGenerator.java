package com.chen1144.wheel.util;

public class ConcurrentGenerator<T> implements Generator<T> {
    private Generator<T> innerGenerator;

    private ConcurrentGenerator(Generator<T> generator){
        this.innerGenerator = generator;
    }

    public static <T> ConcurrentGenerator<T> of(Generator<T> generator){
        return new ConcurrentGenerator<>(generator);
    }

    @Override
    public synchronized T regenerate(T reference) {
        return innerGenerator.regenerate(reference);
    }

    @Override
    public synchronized void reset() {
        innerGenerator.reset();
    }
}
