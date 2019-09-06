package com.chen1144.wheel.gui.view;

import com.chen1144.wheel.gui.AbstractView;
import com.chen1144.wheel.gui.adapter.ListRenderer;

import javax.swing.*;
import java.util.function.Consumer;

import static javax.swing.ListSelectionModel.*;

public class ListView<T> extends AbstractView<JList<T>> {
    private T[] data;

    public ListView() {
        super(new JList<>());
        getComponent().setSelectionMode(SINGLE_SELECTION);
    }

    public void setData(T[] data){
        this.data = data;
        getComponent().setListData(this.data);
    }

    public T[] getData(){
        return data;
    }

    public void setRenderer(ListRenderer<T> renderer){
        getComponent().setCellRenderer((list, value, index, isSelected, cellHasFocus) -> renderer.render(value, isSelected).getComponent());
    }

    public void addOnClick(Consumer<T> consumer){
        getComponent().addListSelectionListener(event -> {
            T item = data[event.getFirstIndex()];
            consumer.accept(item);
        });
    }
}
