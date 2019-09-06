package com.chen1144.wheel.gallery.loader;

import java.util.List;

public class SiteLoader {
    private String title;
    private GalleryLoader galleryLoader;
    private ImageLoader imageLoader;
    private List<CategoryLoader> categories;
    private CategoryLoader search;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GalleryLoader getGalleryLoader() {
        return galleryLoader;
    }

    public void setGalleryLoader(GalleryLoader galleryLoader) {
        this.galleryLoader = galleryLoader;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public List<CategoryLoader> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryLoader> categories) {
        this.categories = categories;
    }

    public CategoryLoader getSearch() {
        return search;
    }

    public void setSearch(CategoryLoader search) {
        this.search = search;
    }
}
