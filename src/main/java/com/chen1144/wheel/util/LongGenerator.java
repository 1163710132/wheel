package com.chen1144.wheel.util;

import java.util.concurrent.atomic.AtomicLong;

public class LongGenerator implements Generator<Long> {
    private AtomicLong atomic;

    public LongGenerator(){
        this.atomic = new AtomicLong();
    }

    @Override
    public Long regenerate(Long reference) {
        return atomic.getAndIncrement();
    }

    @Override
    public void reset() {
        atomic.set(0L);
    }
}
