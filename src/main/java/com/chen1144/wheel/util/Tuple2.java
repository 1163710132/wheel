package com.chen1144.wheel.util;

import java.util.Objects;

public class Tuple2<F, S> {
    private final F first;
    private final S second;

    private Tuple2(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <F, S> Tuple2<F, S> of(F first, S second){
        return new Tuple2<>(first, second);
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple2)) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(first, tuple2.first) &&
                Objects.equals(second, tuple2.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Tuple2{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
