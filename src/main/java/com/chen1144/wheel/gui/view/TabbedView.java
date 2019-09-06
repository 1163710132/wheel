package com.chen1144.wheel.gui.view;

import com.chen1144.wheel.gui.AbstractView;

import javax.swing.*;

public class TabbedView extends AbstractView<JTabbedPane> {
    public TabbedView() {
        super(new JTabbedPane());
    }

    public void addTab(String tabText, AbstractView view){
        view.setParent(this);
        getComponent().addTab(tabText, view.getComponent());
    }

    public void removeTab(AbstractView view){
        view.setParent(null);
        getComponent().remove(view.getComponent());
    }
}
