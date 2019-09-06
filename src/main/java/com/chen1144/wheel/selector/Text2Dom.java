package com.chen1144.wheel.selector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.function.Function;

public class Text2Dom implements Function<String, Elements> {
    private String matcher;
    private String pattern;
    private String selector;

    public Text2Dom(String matcher, String pattern, String selector) {
        this.matcher = matcher;
        this.pattern = pattern;
        this.selector = selector;
    }

    @Override
    public Elements apply(String s) {
        try {
            String url = Text2Text.t2t(matcher, pattern, s);
            Document document = Jsoup.parse(new URL(url), 1000);
            return Dom2Dom.d2d(selector, document);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
