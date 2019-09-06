package com.chen1144.wheel.gallery.loader;

import com.chen1144.wheel.selector.Text2Text;

public class ImageLoader {
    private Text2Text thumbnail;
    private Text2Text common;
    private Text2Text hiRes;

    public Text2Text getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Text2Text thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Text2Text getCommon() {
        return common;
    }

    public void setCommon(Text2Text common) {
        this.common = common;
    }

    public Text2Text getHiRes() {
        return hiRes;
    }

    public void setHiRes(Text2Text hiRes) {
        this.hiRes = hiRes;
    }
}
