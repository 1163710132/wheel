package com.chen1144.wheel.string;

import java.util.Arrays;

public class UString {
    private int[] codePoints;

    public UString(int[] codePoints) {
        this.codePoints = Arrays.copyOf(codePoints, codePoints.length);
    }

    public int length(){
        return codePoints.length;
    }

    public int charAt(int index){
        return codePoints[index];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int codePoint: codePoints){
            builder.appendCodePoint(codePoint);
        }
        return builder.toString();
    }
}
