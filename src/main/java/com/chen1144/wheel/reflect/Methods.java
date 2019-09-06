package com.chen1144.wheel.reflect;

import com.chen1144.wheel.util.Result;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

public class Methods {
    public static Result invoke(Object object, Method method, Object[] args){
        try {
            return Result.of(method.invoke(object, args));
        }catch (ReflectiveOperationException e){
            throw new RuntimeException(e);
        }
    }
    public static Result invoke(Object object, Method method, Map<String, Object> args){
        try {
            Object[] argsArray = new Object[method.getParameterCount()];
            Parameter[] params = method.getParameters();
            for (int i = 0; i < params.length; i++) {
                argsArray[i] = args.get(params[i].getName());
            }
            return Result.of(method.invoke(object, argsArray));
        }catch (ReflectiveOperationException e){
            throw new RuntimeException(e);
        }
    }
    public static <T> T construct(Constructor<T> constructor, Map<String, Object> args){
        try {
            Object[] argsArray = new Object[constructor.getParameterCount()];
            Parameter[] params = constructor.getParameters();
            for (int i = 0; i < params.length; i++) {
                argsArray[i] = args.get(params[i].getName());
            }
            return constructor.newInstance(argsArray);
        }catch (ReflectiveOperationException e){
            throw new RuntimeException(e);
        }
    }
}
