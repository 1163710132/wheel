package com.chen1144.wheel.state;

public class ActionInstance<Id, In, Args, Out> extends AbstractInstance<Action<Id, In, Args, Out>, ActionArgs<Id, In, Args, Out>> {
    public ActionInstance(Action<Id, In, Args, Out> action, ActionArgs<Id, In, Args, Out> args) {
        super(action, args);
    }
}
