package com.chen1144.wheel.gui.view;

import com.chen1144.wheel.gui.AbstractView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class LinearBox extends AbstractView<JComponent> {
    private List<AbstractView> children;

    public LinearBox(int axis) {
        super(new Box(axis));
        children = new ArrayList<>();
    }

    public LinearBox addWidget(AbstractView widget){
        widget.setParent(this);
        children.add(widget);
        var component = widget.getComponent();
        this.getComponent().add(component);
        return this;
    }

    public void removeWidget(AbstractView widget){
        widget.setParent(null);
        children.remove(widget);
        this.getComponent().remove(widget.getComponent());
    }

    public List<AbstractView> getChildren(){
        return new ArrayList<>(children);
    }
}
