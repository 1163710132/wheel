package com.chen1144.wheel.util;

public class Result {
    private Object content;

    private Result(Object content){
        this.content = content;
    }

    public static Result of(Object content){
        return new Result(content);
    }

    public <T> T as(Class<T> type){
        return type.cast(content);
    }
}
