package com.chen1144.wheel.gui.window;

import javax.swing.*;
import java.awt.*;

public class Window {
    private final JFrame window;

    public Window() {
        this.window = new JFrame(){
            @Override
            public void paint(Graphics g) {
                Window.this.paint((Graphics2D)g);
            }
        };
        JComponent component;
        component.paintComponents();
        ScrollPane scrollPane;
        scrollPane.paint();
    }

    public void paint(Graphics2D graphics){

    }
}
