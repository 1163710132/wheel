package com.chen1144.wheel.gui.window;

import com.chen1144.wheel.gui.AbstractView;
import com.chen1144.wheel.gui.AbstractWindow;

public class FixedWindow extends AbstractWindow {
    private AbstractView content;

    public FixedWindow() {
        getComponent().setResizable(false);
    }

    public FixedWindow setWidth(int width){
        getComponent().setSize(width, getComponent().getHeight());
        return this;
    }

    public FixedWindow setHeight(int height){
        getComponent().setSize(getComponent().getWidth(), height);
        return this;
    }
}
