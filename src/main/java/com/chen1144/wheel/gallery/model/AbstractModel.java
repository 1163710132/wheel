package com.chen1144.wheel.gallery.model;

import com.chen1144.wheel.gallery.loader.SiteLoader;
import org.jsoup.nodes.Element;

public class AbstractModel {
    protected SiteLoader siteLoader;
    protected Element dom;

    public AbstractModel(SiteLoader siteLoader, Element dom) {
        this.siteLoader = siteLoader;
        this.dom = dom;
    }

    public SiteLoader getSiteLoader() {
        return siteLoader;
    }
}
