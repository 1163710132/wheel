package com.chen1144.wheel.state;

public abstract class AbstractInstance<P extends Prototype<? extends Instance<P>, ?>, A> implements Instance<P> {
    private final P prototype;
    private final A args;

    public AbstractInstance(P prototype, A args) {
        this.prototype = prototype;
        this.args = args;
    }

    @Override
    public P getPrototype() {
        return prototype;
    }

    public A getArgs() {
        return args;
    }
}
