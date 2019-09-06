package com.chen1144.wheel.gui.view;

import com.chen1144.wheel.gui.AbstractView;
import com.chen1144.wheel.util.Booleans;

import javax.swing.*;
import java.awt.*;

public class BorderView extends AbstractView<JComponent> {
    private AbstractView north;
    private AbstractView south;
    private AbstractView west;
    private AbstractView east;
    private AbstractView center;

    public BorderView() {
        super(new JComponent() {});
        getComponent().setLayout(new BorderLayout());
    }

    public AbstractView getNorth() {
        return north;
    }

    public void setNorth(AbstractView north) {
        if(this.north != null){
            this.north.setParent(null);
            getComponent().remove(this.north.getComponent());
        }
        if(north != null){
            north.setParent(this);
            getComponent().add(north.getComponent(), BorderLayout.NORTH);
        }
        this.north = north;
    }

    public AbstractView getSouth() {
        return south;
    }

    public void setSouth(AbstractView south) {
        if(this.south != null){
            this.south.setParent(null);
            getComponent().remove(this.south.getComponent());
        }
        if(south != null){
            south.setParent(this);
            getComponent().add(south.getComponent(), BorderLayout.SOUTH);
        }
        this.south = south;
    }

    public AbstractView getWest() {
        return west;
    }

    public void setWest(AbstractView west) {
        if(this.west != null){
            this.west.setParent(null);
            getComponent().remove(this.west.getComponent());
        }
        if(west != null){
            west.setParent(this);
            getComponent().add(west.getComponent(), BorderLayout.WEST);
        }
        this.west = west;
    }

    public AbstractView getEast() {
        return east;
    }

    public void setEast(AbstractView east) {
        if(this.east != null){
            this.east.setParent(null);
            getComponent().remove(this.east.getComponent());
        }
        if(east != null){
            east.setParent(this);
            getComponent().add(east.getComponent(), BorderLayout.EAST);
        }
        this.east = east;
    }

    public AbstractView getCenter() {
        return center;
    }

    public void setCenter(AbstractView center) {
        if(this.center != null){
            this.center.setParent(null);
            getComponent().remove(this.center.getComponent());
        }
        if(center != null){
            center.setParent(this);
            getComponent().add(center.getComponent(), BorderLayout.CENTER);
        }
        this.center = center;
    }
}
