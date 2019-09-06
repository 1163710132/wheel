package com.chen1144.wheel.gui.window;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class RefreshableWindow extends PackedWindow {
    private List<Runnable> onRefresh;

    public RefreshableWindow(){
        super();
        onRefresh = new ArrayList<>();
        addShortcut(KeyEvent.VK_F5, this::refresh);
    }

    public void addOnRefresh(Runnable runnable){
        onRefresh.add(runnable);
    }

    public void refresh(){
        onRefresh.forEach(Runnable::run);
        pack();
    }
}
