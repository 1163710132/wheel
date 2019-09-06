package com.chen1144.wheel.selector;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;

public class Dom2Dom implements Function<Element, Elements> {
    private String selector;

    public Dom2Dom(String selector) {
        this.selector = selector;
    }

    @Override
    public Elements apply(Element element) {
        return element.select(selector);
    }

    public static Elements d2d(String selector, Element element){
        return element.select(selector);
    }
}
