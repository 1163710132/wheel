package com.chen1144.wheel.util;

import io.vavr.Function0;
import io.vavr.Function1;

import java.time.Instant;
import java.util.function.Function;

public class Timer {
    public static long timing(Function0<Void> function0){
        Instant begin = Instant.now();
        function0.apply();
        Instant end = Instant.now();
        return end.toEpochMilli() - begin.toEpochMilli();
    }
}
