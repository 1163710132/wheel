package com.chen1144.wheel.state;

public class StateInstance<Id, Args> extends AbstractInstance<State<Id, Args>, Args> {
    public StateInstance(State<Id, Args> prototype, Args args) {
        super(prototype, args);
    }
}
