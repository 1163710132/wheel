package com.chen1144.wheel.io;

import java.io.IOException;
import java.io.InputStream;

public interface Reader<T> {
    public T readFrom(InputStream inputStream) throws IOException;
}
