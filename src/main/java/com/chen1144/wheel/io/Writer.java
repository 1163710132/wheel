package com.chen1144.wheel.io;

import java.io.IOException;
import java.io.OutputStream;

public interface Writer<T> {
    public void writeTo(OutputStream outputStream, T value) throws IOException;
}
