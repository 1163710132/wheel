package com.chen1144.wheel.state;

public interface Action<Id, In, Args, Out> extends Prototype<ActionInstance<Id, In, Args, Out>, ActionArgs<Id, In, Args, Out>> {
    StateInstance<Id, Out> act(Args args, StateInstance<Id, In> in);

    @Override
    default ActionInstance<Id, In, Args, Out> newInstance(ActionArgs<Id, In, Args, Out> args){
        return new ActionInstance<>(this, args);
    }
}
