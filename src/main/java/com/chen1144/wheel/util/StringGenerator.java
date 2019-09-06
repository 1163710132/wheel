package com.chen1144.wheel.util;

import java.util.HashSet;
import java.util.Set;

public class StringGenerator implements Generator<String>  {
    private Set<String> generated;

    public StringGenerator(){
        generated = new HashSet<>();
    }

    @Override
    public String regenerate(String reference) {
        if(generated.contains(reference)){
            int count = 1;
            while (generated.contains(reference + '_' + String.valueOf(count))){
                count++;
            }
            return reference + '_' + String.valueOf(count);
        }else{
            return reference;
        }
    }

    @Override
    public void reset() {
        generated.clear();
    }
}
