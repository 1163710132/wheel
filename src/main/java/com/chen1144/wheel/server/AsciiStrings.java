package com.chen1144.wheel.server;

public class AsciiStrings {
    //Simple implements
    public static int atoi(AsciiString asciiString){
        return Integer.parseInt(asciiString.toString());
    }
    public static AsciiString itoa(int integer, int radix){
        return AsciiString.valueOf(Integer.toString(integer, radix));
    }
}
