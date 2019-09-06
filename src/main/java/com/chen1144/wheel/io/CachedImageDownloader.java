package com.chen1144.wheel.io;

import java.awt.image.BufferedImage;
import java.util.concurrent.CompletableFuture;

public class CachedImageDownloader implements Downloader<BufferedImage> {
    private Downloader<BufferedImage> downloader;
    private Cache<String, CompletableFuture<BufferedImage>> cache;

    public CachedImageDownloader(){
        downloader = new ImageDownloader();
        cache = new CommonCache<>();
    }

    @Override
    public CompletableFuture<BufferedImage> download(String url) {
        return cache.get(url)
                .orElseGet(()->{
                    var task = downloader.download(url);
                    cache.put(url, task);
                    return task;
                });
    }
}
