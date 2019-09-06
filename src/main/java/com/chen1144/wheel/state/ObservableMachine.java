package com.chen1144.wheel.state;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ObservableMachine<Id> {
    private MachineInstance<Id, ?> currentState;
    private Machine<Id> machine;
    private List<Consumer<ActionInstance<Id, ?, ?, ?>>> observers;

    public ObservableMachine(Machine<Id> machine, Object startArgs){
        this.machine = machine;
        this.currentState = machine.newInstance(((State<Id, Object>) machine.getBegin()).newInstance(startArgs));
        this.observers = new ArrayList<>();
    }

    public MachineInstance<Id, ?> getCurrentState(){
        return currentState;
    }

    public void addObserver(Consumer<ActionInstance<Id, ?, ?, ?>> observer){
        observers.add(observer);
    }

    public <Args> ActionInstance<Id, ?, Args, ?> acceptAction(Id actionId, Args args){
        Id stateId = currentState.getStateInstance().getPrototype().getId();
        Action action =  machine.getAction(stateId, actionId);
        StateInstance<Id, ?> nextState = action.act(args, currentState.getStateInstance());
        ActionInstance<Id, ?, Args, ?> actionInstance = action.newInstance(new ActionArgs(currentState.getStateInstance(), args, nextState));
        observers.forEach(observer->observer.accept(actionInstance));
        currentState = new MachineInstance<>(machine, nextState);
        return actionInstance;
    }
}
