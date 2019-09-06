package com.chen1144.wheel.gui.view;

import com.chen1144.wheel.gui.AbstractView;

import javax.swing.*;
import java.awt.*;

public class ImageView extends AbstractView<JLabel> {
    private ImageIcon icon;

    public ImageView() {
        super(new JLabel());
        this.icon = new ImageIcon();
        getComponent().setIcon(icon);
    }

    public ImageView setImage(Image image){
        icon.setImage(image);
        return this;
    }

    public Image getImage(){
        return icon.getImage();
    }
}
