package com.chen1144.wheel.gui.view;

import com.chen1144.wheel.gui.AbstractView;

import javax.swing.*;

public class Button extends AbstractView<JButton> {
    public Button() {
        super(new JButton());
    }

    public Button(String text){
        this();
        setText(text);
    }

    public void setText(String text){
        getComponent().setText(text);
    }

    public String getText(){
        return getComponent().getText();
    }

    public void addOnClick(Runnable runnable){
        getComponent().addActionListener(event -> {
            runnable.run();
        });
    }
}
