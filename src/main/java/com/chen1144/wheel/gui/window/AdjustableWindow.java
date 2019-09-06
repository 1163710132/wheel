package com.chen1144.wheel.gui.window;

import com.chen1144.wheel.gui.AbstractView;
import com.chen1144.wheel.gui.AbstractWindow;

public class AdjustableWindow extends AbstractWindow {
    private AbstractView content;

    public AdjustableWindow() {

    }

    public AdjustableWindow setWidth(int width){
        getComponent().setSize(width, getComponent().getHeight());
        return this;
    }

    public AdjustableWindow setHeight(int height){
        getComponent().setSize(getComponent().getWidth(), height);
        return this;
    }
}
