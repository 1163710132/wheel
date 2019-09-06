package com.chen1144.wheel.gallery.loader;

import com.chen1144.wheel.selector.Dom2Text;
import com.chen1144.wheel.selector.Text2Dom;

public class GalleryLoader {
    private Text2Dom gallery;
    private Dom2Text imageSelector;
    private Dom2Text title;

    public Text2Dom getGallery() {
        return gallery;
    }

    public void setGallery(Text2Dom gallery) {
        this.gallery = gallery;
    }

    public Dom2Text getImageSelector() {
        return imageSelector;
    }

    public void setImageSelector(Dom2Text imageSelector) {
        this.imageSelector = imageSelector;
    }

    public Dom2Text getTitle() {
        return title;
    }

    public void setTitle(Dom2Text title) {
        this.title = title;
    }
}
