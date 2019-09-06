package com.chen1144.wheel.io;

import java.util.concurrent.CompletableFuture;

public interface Downloader<T> {
    CompletableFuture<T> download(String url);
}
