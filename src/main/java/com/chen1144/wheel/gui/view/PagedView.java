package com.chen1144.wheel.gui.view;

import com.chen1144.wheel.gui.AbstractView;
import com.chen1144.wheel.gui.adapter.PageAdapter;
import com.chen1144.wheel.util.Cancellable;
import com.chen1144.wheel.util.Range;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PagedView<T> extends AbstractView<JComponent> {
    private LineText currentPageLine;
    private int currentPageValue;
    private int pageCount;
    private Button prevPage;
    private Button nextPage;
    private Button go;
    private PageAdapter<T> adapter;
    private AbstractView renderedPage;
    private FutureTask<Void> refreshTask;

    public PagedView() {
        super(new JComponent() { });
        this.currentPageLine = new LineText();
        this.prevPage = new Button("<");
        this.nextPage = new Button(">");
        this.go = new Button("go");
        this.currentPageValue = 0;
        this.pageCount = 0;
        getComponent().setLayout(new BorderLayout());
        getComponent().add(prevPage.getComponent(), BorderLayout.WEST);
        getComponent().add(nextPage.getComponent(), BorderLayout.EAST);
        getComponent().add(new HorizontalBox(){{
            this.addWidget(currentPageLine);
            this.addWidget(go);
        }}.getComponent(), BorderLayout.NORTH);
        this.prevPage.addOnClick(()->{
            if(currentPageValue > 0){
                currentPageValue--;
            }
            loadPage(currentPageValue);
        });
        this.nextPage.addOnClick(()->{
            if(currentPageValue < pageCount - 1){
                currentPageValue++;
            }
            loadPage(currentPageValue);
        });
        this.go.addOnClick(()->{
            int pageIndex = Integer.parseInt(currentPageLine.getText());
            if(Range.between(0, pageCount).contains(pageIndex)){
                currentPageValue = pageIndex;
            }
            loadPage(currentPageValue);
        });
    }

    public void loadPage(int index){
        if(refreshTask != null){
            refreshTask.cancel(true);
        }
        refreshTask = new FutureTask<>(()->{
            T page = getAdapter().getPage(index);
            this.pageCount = getAdapter().getPageCount(page);
            if(renderedPage != null){
                renderedPage.setParent(null);
                getComponent().remove(renderedPage.getComponent());
            }
            renderedPage = getAdapter().render(getAdapter().getPage(index));
            renderedPage.setParent(this);
            getComponent().add(renderedPage.getComponent(), BorderLayout.CENTER);
            return null;
        });
        refreshTask.run();
    }

    public PageAdapter<T> getAdapter() {
        return adapter;
    }

    public void setAdapter(PageAdapter<T> adapter) {
        this.adapter = adapter;
    }
}
