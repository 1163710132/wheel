package com.chen1144.wheel.gui;

import java.util.function.Function;

public class AbstractInflater<T> implements TypedInflater<T> {
    private final Class<T> type;
    private final Function<T, AbstractView> inflater;

    public AbstractInflater(Class<T> type, Function<T, AbstractView> inflater){
        this.type = type;
        this.inflater = inflater;
    }

    @Override
    public Class<T> getModelType() {
        return type;
    }

    @Override
    public AbstractView inflateTyped(T model) {
        return inflater.apply(model);
    }
}
