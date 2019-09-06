package com.chen1144.wheel.gallery;

import com.chen1144.wheel.gui.view.ListView;
import com.chen1144.wheel.gui.view.Scrollable;
import com.chen1144.wheel.gui.window.FixedWindow;

public class GalleryMain {
    public static void main(String[] args) {
        new FixedWindow(){{
            setWidth(256);
            setHeight(1024);
            setContent(new Scrollable(){{
                this.setContent(new ListView(){{
//                    this.setData();
                }});
            }});
        }};
    }
}
