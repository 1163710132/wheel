package com.chen1144.wheel.server;

import com.chen1144.wheel.util.ByteList;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Stream;

public class AsciiString implements CharSequence {
    private byte[] content;
    private int begin;
    private int end;
    private int hash;

    private AsciiString(byte[] content, int begin, int end) {
        this.content = content;
        this.begin = begin;
        this.end = end;
    }
    private AsciiString(byte[] content) {
        this(content, 0, content.length);
    }

    public static AsciiString valueOf(String string){
        return new AsciiString(string.getBytes());
    }

    public static AsciiString valueOf(byte[] bytes){
        return new AsciiString(bytes);
    }

    @Override
    public int length() {
        return end - begin;
    }

    @Override
    public char charAt(int index) {
        return (char)content[index + begin];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiString(content, start + this.begin, end + this.begin);
    }

    @Override
    public int hashCode() {
        if (this.hash == 0 && content.length > 0) {
            int hash = 0;
            for (byte v : content) {
                hash = 31 * hash + (v & 0xff);
            }
            this.hash = hash;
        }
        return this.hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AsciiString)) return false;
        AsciiString that = (AsciiString) o;
        return equals(that);
    }

    public boolean equals(AsciiString that){
        return that != null && hash == that.hash &&
                Arrays.equals(content, begin, end, that.content, that.begin, that.end);
    }

    @Override
    public String toString() {
        char[] chars = new char[length()];
        for(int i = begin;i < end;i++){
            chars[i - begin] = (char)content[i];
        }
        return String.valueOf(chars);
    }

    public byte[] toByteArray(){
        return Arrays.copyOfRange(content, begin, end);
    }

    public AsciiString[] split(byte ch){
        boolean found = true;
        int count = 0;
        for(int i = 0;i < content.length;i++){
            if(content[i] == ch){
                if(!found){
                    found = true;
                }
            }else{
                if(found){
                    found = false;
                    count++;
                }
            }
        }
        AsciiString[] split = new AsciiString[count];
        int ptr = 0;
        for(int i = 0;i < split.length;i++){
            ByteList subString = new ByteList();
            while (content[ptr] == ch){
                ptr++;
            }
            while (ptr < content.length && content[ptr] != ch){
                subString.add(content[ptr]);
                ptr++;
            }
            split[i] = AsciiString.valueOf(subString.toArray());
        }
        return split;
    }
}
