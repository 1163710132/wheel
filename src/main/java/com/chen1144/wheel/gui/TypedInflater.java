package com.chen1144.wheel.gui;

import java.util.function.Function;

public interface TypedInflater<T> extends Inflater {
    Class<T> getModelType();
    AbstractView inflateTyped(T model);
    @Override
    default AbstractView inflate(Object model){
        return inflateTyped(getModelType().cast(model));
    }

    @Override
    default boolean canInflate(Object object){
        return getModelType().isInstance(object);
    }

    public static <T> AbstractInflater<T> of(Class<T> type, Function<T, AbstractView> inflater){
        return new AbstractInflater<>(type, inflater);
    }
}
