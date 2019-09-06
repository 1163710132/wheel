package com.chen1144.wheel.util;

import java.util.concurrent.Callable;

public class Exceptions {
    public static void runWithoutException(ExceptionalRunnable runnable){
        runnable.toRunnable().run();
    }
    public static <T> T callWithoutException(Callable<T> callable){
        try {
            return callable.call();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
