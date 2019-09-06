package com.chen1144.wheel.gui;

public interface Inflater {
    AbstractView inflate(Object object);
    boolean canInflate(Object object);
}
