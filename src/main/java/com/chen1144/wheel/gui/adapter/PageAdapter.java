package com.chen1144.wheel.gui.adapter;

import com.chen1144.wheel.gui.AbstractView;

public interface PageAdapter<Page> {
    int getPageCount(Page page);
    Page getPage(int pageIndex);
    AbstractView render(Page page);
}
