package com.chen1144.wheel.selector;

import org.jsoup.nodes.Element;

import java.util.function.Function;
import java.util.stream.Stream;

public class Dom2Text implements Function<Element, Stream<String>> {
    private String selector;
    private String matcher;
    private String pattern;

    public Dom2Text(String selector, String matcher, String pattern) {
        this.selector = selector;
        this.matcher = matcher;
        this.pattern = pattern;
    }

    @Override
    public Stream<String> apply(Element element) {
        return Dom2Dom.d2d(selector, element).stream()
                .map(Element::toString)
                .map(source -> Text2Text.t2t(matcher, pattern, source));
    }
}
