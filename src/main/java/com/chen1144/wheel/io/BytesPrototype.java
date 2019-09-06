package com.chen1144.wheel.io;

import com.chen1144.wheel.core.Prototype;

import java.io.IOException;
import java.io.OutputStream;

public class BytesPrototype implements Prototype<byte[]>, Writer<byte[]> {
    @Override
    public byte[] newInstance(Object... parameters) {
        if(parameters.length == 1){
            if(parameters[0] instanceof Number){
                int length = ((Number) parameters[0]).intValue();
                if(length > 0){
                    return new byte[length];
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void writeTo(OutputStream outputStream, byte[] value) throws IOException {
        outputStream.write(value);
    }
}
