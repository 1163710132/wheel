package com.chen1144.wheel.util;

public class Range<T extends Comparable<? super T>> {
    private final T begin;
    private final T end;

    private Range(T begin, T end) {
        this.begin = begin;
        this.end = end;
    }

    public static <T extends Comparable<? super T>> Range<T> between(T begin, T end){
        return new Range<T>(begin, end);
    }

    public boolean contains(T value){
        if(value != null){
            if(begin == null || begin.compareTo(value) <= 0){
                return end == null || end.compareTo(value) > 0;
            }
        }
        return false;
    }

    public T getBegin() {
        return begin;
    }

    public T getEnd() {
        return end;
    }
}
