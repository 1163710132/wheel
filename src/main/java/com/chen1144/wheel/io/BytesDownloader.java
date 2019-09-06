package com.chen1144.wheel.io;

import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class BytesDownloader implements Downloader<byte[]> {
    private HttpClient client;

    public BytesDownloader(){
        client = HttpClient.newBuilder().cookieHandler(new CookieManager()).build();
    }

    @Override
    public CompletableFuture<byte[]> download(String url) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofByteArray())
                .thenApply(HttpResponse::body);
    }
}
