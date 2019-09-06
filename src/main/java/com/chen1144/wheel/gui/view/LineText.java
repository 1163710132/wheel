package com.chen1144.wheel.gui.view;

import com.chen1144.wheel.gui.AbstractView;

import javax.swing.*;

public class LineText extends AbstractView<JTextField> {
    public LineText() {
        super(new JTextField());
    }

    public String getText(){
        return getComponent().getText();
    }
}
