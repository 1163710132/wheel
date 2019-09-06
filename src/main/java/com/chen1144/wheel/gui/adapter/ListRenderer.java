package com.chen1144.wheel.gui.adapter;

import com.chen1144.wheel.gui.AbstractView;

@FunctionalInterface
public interface ListRenderer<T> {
    AbstractView render(T item, boolean selected);
}
