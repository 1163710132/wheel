package com.chen1144.wheel.gallery.model;

import com.chen1144.wheel.gallery.loader.SiteLoader;

import java.util.List;

public class SiteListModel {
    private final List<SiteLoader> siteList;

    public SiteListModel(List<SiteLoader> siteList) {
        this.siteList = siteList;
    }

    public List<SiteLoader> getSiteList() {
        return siteList;
    }
}
