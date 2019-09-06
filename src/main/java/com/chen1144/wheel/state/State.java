package com.chen1144.wheel.state;

import java.util.Objects;

public class State<Id, Args> implements Prototype<StateInstance<Id, Args>, Args> {
    private final Id id;

    public State(Id id){
        this.id = id;
    }

    public Id getId() {
        return id;
    }

    @Override
    public StateInstance<Id, Args> newInstance(Args args) {
        return new StateInstance<>(this, args);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State<?, ?> state = (State<?, ?>) o;
        return Objects.equals(id, state.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
