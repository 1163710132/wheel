package com.chen1144.wheel.gallery.model;

import com.chen1144.wheel.gallery.loader.CategoryLoader;
import com.chen1144.wheel.gallery.loader.SiteLoader;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class CategoryModel extends AbstractModel {
    private CategoryLoader categoryLoader;
    private List<GalleryModel> galleries;
    private int currentPage;
    private int pageCount;
    private int pageShift;

    public CategoryModel(SiteLoader loader, Element dom, CategoryLoader categoryLoader) {
        super(loader, dom);
        this.categoryLoader = categoryLoader;
    }

    public void loadPage(String page){
        Element dom = getCategoryLoader().getSitePage().apply(page).first();
        currentPage = Integer.parseInt(page);
        pageCount = Integer.parseInt(getCategoryLoader().getPageCount().apply(dom).findFirst().orElse("-1"));
        pageShift = Integer.parseInt(getCategoryLoader().getPageShift());
//        galleries = getCategoryLoader().getGallerySelector()
//                .apply(dom)
//                .map(getSiteLoader().getGalleryLoader().getGallery())
//                .map(Elements::first)
//                .map(galleryDom -> getSiteLoader().getGalleryLoader())
    }

    public void setDom(Element dom){
        this.dom = dom;
    }

    public CategoryLoader getCategoryLoader() {
        return categoryLoader;
    }
}
