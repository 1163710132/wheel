package com.chen1144.wheel.gui;

import javax.swing.*;
import java.awt.event.*;

public abstract class AbstractWindow extends AbstractMonoContainer<JFrame> {

    public AbstractWindow(){
        super(new JFrame());
        addShortcut(0, null);
    }

    public void show(){
        getComponent().setVisible(true);
    }

    public void hide(){
        getComponent().setVisible(false);
    }

    public void addShortcut(int keyCode, Runnable action){
        getComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == keyCode){
                    action.run();
                }
            }
        });
    }

    public void addOnClosed(Runnable action){
        getComponent().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                action.run();
            }
        });
    }
}
