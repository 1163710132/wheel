package com.chen1144.wheel.gallery.loader;

import com.chen1144.wheel.selector.Dom2Text;
import com.chen1144.wheel.selector.Text2Dom;

public class CategoryLoader {
    private String title;
    private Text2Dom sitePage;
    private String pageShift;
    private Dom2Text pageCount;
    private Dom2Text gallerySelector;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Text2Dom getSitePage() {
        return sitePage;
    }

    public void setSitePage(Text2Dom sitePage) {
        this.sitePage = sitePage;
    }

    public String getPageShift() {
        return pageShift;
    }

    public void setPageShift(String pageShift) {
        this.pageShift = pageShift;
    }

    public Dom2Text getPageCount() {
        return pageCount;
    }

    public void setPageCount(Dom2Text pageCount) {
        this.pageCount = pageCount;
    }

    public Dom2Text getGallerySelector() {
        return gallerySelector;
    }

    public void setGallerySelector(Dom2Text gallerySelector) {
        this.gallerySelector = gallerySelector;
    }
}
