package com.chen1144.wheel.gui;

import java.awt.*;

public abstract class AbstractMonoContainer<T extends Container> extends AbstractView<T> {
    private AbstractView content;

    public AbstractMonoContainer(T container){
        super(container);
    }

    public AbstractView setContent(AbstractView widget){
        if(widget == null){
            if(content != null){
                content.setParent(null);
                getComponent().remove(content.getComponent());
            }
        }else{
            if(content != null){
                content.setParent(null);
                getComponent().remove(content.getComponent());
            }
            widget.setParent(this);
            getComponent().add(widget.getComponent());
        }
        content = widget;
        return this;
    }
}
