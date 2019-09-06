package com.chen1144.wheel.state;

public class ActionArgs<Id, In, Args, Out> {
    private final StateInstance<Id, In> begin;
    private final Args args;
    private final StateInstance<Id, Out> end;

    public ActionArgs(StateInstance<Id, In> begin, Args args, StateInstance<Id, Out> end) {
        this.begin = begin;
        this.args = args;
        this.end = end;
    }

    public StateInstance<Id, In> getBegin() {
        return begin;
    }

    public Args getArgs() {
        return args;
    }

    public StateInstance<Id, Out> getEnd() {
        return end;
    }
}
