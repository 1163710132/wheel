package com.chen1144.wheel.state;

public interface Instance<P extends Prototype<? extends Instance<P>, ?>> {
    P getPrototype();
}
