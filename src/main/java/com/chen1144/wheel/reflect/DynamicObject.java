package com.chen1144.wheel.reflect;

import com.chen1144.wheel.util.Exceptions;

public class DynamicObject<T> {
    private final T object;

    private DynamicObject(T object){
        this.object = object;
    }

    public static <T> DynamicObject<T> of(T object){
        return new DynamicObject<>(object);
    }

    public void setField(String fieldName, Object value){
        Exceptions.runWithoutException(()->object.getClass().getField(fieldName).set(object, value));
    }

    public <Field> Field getField(String fieldName, Class<Field> fieldType){
        return Exceptions.callWithoutException(()->{
            return fieldType.cast(object.getClass().getField(fieldName).get(object));
        });
    }

    public void setProperty(String propertyName, Object value){
        Exceptions.runWithoutException(()->{
            String setterName = toSetterName(propertyName);
            for(var method: object.getClass().getMethods()){
                if(method.getParameterCount() == 1 && method.getName().equals(setterName)){
                    method.invoke(object, value);
                    return;
                }
            }
            throw new RuntimeException("Cannot find setter");
        });
    }

    public <Property> Property getProperty(String propertyName, Class<Property> propertyType){
        return Exceptions.callWithoutException(()->{
            String getterName = toGetterName(propertyName);
            return propertyType.cast(object.getClass().getMethod(propertyName).invoke(object));
        });
    }

    public static String toGetterName(String propertyName){
        return "get" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
    }

    public static String toSetterName(String propertyName){
        return "set" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
    }
}
