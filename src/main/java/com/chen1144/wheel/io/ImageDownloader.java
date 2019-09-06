package com.chen1144.wheel.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public class ImageDownloader implements Downloader<BufferedImage> {
    @Override
    public CompletableFuture<BufferedImage> download(String url) {
        return CompletableFuture.supplyAsync(()->{
            try {
                return ImageIO.read(new URL(url));
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });
    }
}
