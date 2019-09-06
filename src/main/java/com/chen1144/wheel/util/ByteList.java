package com.chen1144.wheel.util;

import java.util.*;

public class ByteList{
    private byte[] content;
    private int size;

    public ByteList(int capacity){
        content = new byte[capacity];
        size = 0;
    }

    public ByteList(){
        this(16);
    }

    public int size() {
        return size;
    }

    public byte[] toArray() {
        byte[] a = new byte[size];
        for(int i = 0;i < size;i++){
            a[i] = content[i];
        }
        return a;
    }

    public boolean add(byte aByte) {
        if(size == content.length){
            content = Arrays.copyOf(content, size * 2);
        }
        content[size++] = aByte;
        return true;
    }

    public void addAll(byte[] bytes){
        mayResize(bytes.length + content.length);
        System.arraycopy(bytes, 0, content, size, bytes.length);
        size += bytes.length;
    }

    private void mayResize(int minSize){
        if(minSize > content.length){
            int newSize = content.length;
            while (newSize < minSize){
                newSize *= 2;
            }
            content = Arrays.copyOf(content, newSize);
        }
    }

    public void clear() {
        this.size = 0;
    }
}
