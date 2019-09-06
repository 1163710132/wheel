package com.chen1144.wheel.gui.window;

import com.chen1144.wheel.gui.AbstractWindow;

public class PackedWindow extends AbstractWindow {
    public PackedWindow() {
        getComponent().setResizable(false);
    }

    public PackedWindow pack(){
        getComponent().pack();
        return this;
    }
}
