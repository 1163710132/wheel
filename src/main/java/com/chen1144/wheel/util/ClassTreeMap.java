package com.chen1144.wheel.util;

import java.util.*;

public class ClassTreeMap<T> {
    private final Map<Class, T> map;

    public ClassTreeMap(Map<Class, T> innerMap){
        map = innerMap;
    }

    public ClassTreeMap(){
        this(new HashMap<>());
    }

    public void put(Class key, T value){
        map.put(key, value);
    }

    public Optional<T> getFirst(Class key){
        if(!key.isInterface()){
            Class clazz = key;
            while (clazz != null){
                if(map.containsKey(clazz)){
                    return Optional.of(map.get(clazz));
                }
                clazz = clazz.getSuperclass();
            }
        }
        return Optional.empty();
    }

    public List<T> getAll(Class key){
        List<T> results = new ArrayList<>();
        if(!key.isInterface()){
            Class clazz = key;
            while (clazz != null){
                if(map.containsKey(clazz)){
                    results.add(map.get(clazz));
                }
                clazz = clazz.getSuperclass();
            }
        }
        return results;
    }
}
