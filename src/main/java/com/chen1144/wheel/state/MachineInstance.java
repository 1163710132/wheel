package com.chen1144.wheel.state;

public class MachineInstance<Id, Args> extends AbstractInstance<Machine<Id>, StateInstance<Id, Args>> {
    public MachineInstance(Machine<Id> prototype, StateInstance<Id, Args> args) {
        super(prototype, args);
    }

    public StateInstance<Id, Args> getStateInstance(){
        return getArgs();
    }

    public boolean isBegin(){
        return getPrototype().getBegin().equals(getArgs().getPrototype());
    }

    public boolean isEnd(){
        return getPrototype().getEnd().equals(getArgs().getPrototype());
    }
}
