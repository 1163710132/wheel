package com.chen1144.wheel.gui;

import com.chen1144.wheel.util.ClassTreeMap;

public class InflaterMap implements Inflater {
    private ClassTreeMap<TypedInflater> map;

    public void put(TypedInflater inflater){
        map.put(inflater.getModelType(), inflater);
    }

    @Override
    public AbstractView inflate(Object object) {
        return map.getFirst(object.getClass())
                .map(inflater -> inflater.inflate(object))
                .orElseThrow();
    }

    @Override
    public boolean canInflate(Object object) {
        return map.getFirst(object.getClass()).isPresent();
    }
}
