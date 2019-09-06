package com.chen1144.wheel.gui.view;

import com.chen1144.wheel.gui.AbstractView;

import javax.swing.*;

public class Label extends AbstractView<JLabel> {
    public Label() {
        super(new JLabel());
    }

    public Label setText(String text){
        getComponent().setText(text);
        return this;
    }

    public String getText(){
        return getComponent().getText();
    }
}
