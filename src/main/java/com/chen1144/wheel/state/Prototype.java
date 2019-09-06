package com.chen1144.wheel.state;

public interface Prototype<I extends Instance<? extends Prototype<I, A>>, A> {
    I newInstance(A args);
}
