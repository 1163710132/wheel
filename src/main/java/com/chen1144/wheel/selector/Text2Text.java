package com.chen1144.wheel.selector;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text2Text implements Function<String, String> {
    private String matcher;
    private String pattern;

    public Text2Text(String matcher, String pattern) {
        this.matcher = matcher;
        this.pattern = pattern;
    }

    @Override
    public String apply(String s) {
        return t2t(matcher, pattern, s);
    }

    public static String t2t(String matcher, String pattern, String source){
        if(matcher == null || matcher.length() == 0){
            return pattern;
        }
        Pattern ptn = Pattern.compile(matcher);
        Matcher m = ptn.matcher(source);
        if(m.find()){
            Object[] args = new Object[m.groupCount()];
            for(int i = 1;i <= args.length;i++){
                args[i] = m.group(i);
            }
            return String.format(pattern, args);
        }else{
            return "";
        }
    }
}
