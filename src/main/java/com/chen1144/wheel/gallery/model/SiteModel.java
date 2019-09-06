package com.chen1144.wheel.gallery.model;

import com.chen1144.wheel.gallery.loader.SiteLoader;

public class SiteModel {
    private SiteLoader siteLoader;

    public SiteModel(SiteLoader siteLoader){
        this.siteLoader = siteLoader;
    }

    public SiteLoader getSiteLoader() {
        return siteLoader;
    }
}
