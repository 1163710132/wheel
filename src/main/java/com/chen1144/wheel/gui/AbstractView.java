package com.chen1144.wheel.gui;

import java.awt.*;

public abstract class AbstractView<T extends Container> {
    private final T component;
    private AbstractView parent;

    public AbstractView(T component){
        this.component = component;
    }

    public T getComponent(){
        return component;
    }

    public void setParent(AbstractView widget){
        if(parent == null){
            parent = widget;
        }else throw new RuntimeException();
    }

    public AbstractView getParent(){
        return parent;
    }

    public  <U extends AbstractView<?>> U as(Class<U> clazz){
        return clazz.cast(this);
    }
}
