package com.chen1144.wheel.gallery;

import com.chen1144.wheel.gallery.loader.CategoryLoader;
import com.chen1144.wheel.gallery.loader.SiteLoader;
import com.chen1144.wheel.gallery.model.GalleryModel;
import com.chen1144.wheel.gallery.model.SiteListModel;
import com.chen1144.wheel.gallery.model.CategoryModel;
import com.chen1144.wheel.gallery.model.SiteModel;
import com.chen1144.wheel.gui.AbstractView;
import com.chen1144.wheel.gui.view.*;
import com.chen1144.wheel.gui.window.FixedWindow;
import com.chen1144.wheel.gui.window.RefreshableWindow;
import com.chen1144.wheel.reflect.DynamicObject;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.jsoup.nodes.Element;

public class Inflaters {
    public static AbstractView inflateSiteListModel(SiteListModel siteListModel){
        return new ListView<SiteLoader>(){{
            this.setData(siteListModel.getSiteList().toArray(SiteLoader[]::new));
            this.setRenderer((siteLoader, selected)->{
                return new Label(){{
                    this.setText(siteLoader.getTitle());
                }};
            });
            this.addOnClick(siteLoader -> {
                new FixedWindow(){{
                    this.setContent(inflateSiteModel(new SiteModel(siteLoader)));
                    this.show();
                }};
            });
        }};
    }

    public static AbstractView inflateSiteModel(SiteModel siteModel){
        return new ListView<CategoryLoader>(){{
            this.setData(siteModel.getSiteLoader().getCategories().toArray(CategoryLoader[]::new));
            this.setRenderer((categoryLoader, selected)->{
                return new Label(){{
                    this.setText(categoryLoader.getTitle());
                }};
            });
            this.addOnClick(categoryLoader -> {
                new RefreshableWindow(){{
                    this.addOnRefresh(()->{
                        Element element = categoryLoader.getSitePage().apply(categoryLoader.getPageShift()).get(0);
                        CategoryModel categoryModel = new CategoryModel(siteModel.getSiteLoader(), element, categoryLoader);
                        setContent(inflateCategoryModel(categoryModel));
                    });
                    this.refresh();
                    this.show();
                }};
            });
        }};
    }

    public static AbstractView inflateCategoryModel(CategoryModel categoryModel){
        return new VerticalBox(){{
            this.addWidget(new ListView(){{

            }});
            this.addWidget(new HorizontalBox(){{
                LineText currentPage = new LineText();
                this.addWidget(currentPage);
                this.addWidget(new Button(){{
                    addOnClick(()->{
                        String pageString = currentPage.getText();

                    });
                }});
            }});
        }};
    }

//    public static AbstractView inflateGalleryModel(GalleryModel galleryModel){
//
//    }
}
