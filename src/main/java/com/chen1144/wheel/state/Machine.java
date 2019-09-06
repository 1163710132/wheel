package com.chen1144.wheel.state;

import com.chen1144.wheel.util.Generator;
import com.chen1144.wheel.util.Pair;

import java.util.Map;

public class Machine<Id> implements Prototype<MachineInstance<Id, ?>, StateInstance<Id, ?>> {
    private final Map<Id, State<Id, ?>> stateMap;
    private final State<Id, ?> begin;
    private final State<Id, ?> end;
    private Map<Pair<Id, Id>, Action<Id, ?, ?, ?>> actionMap;

    protected Machine(Id begin, Id end, Map<Id, State<Id, ?>> states, Map<Pair<Id, Id>, Action<Id, ?, ?, ?>> actions){
        this.stateMap = states;
        this.begin = stateMap.get(begin);
        this.end = stateMap.get(end);
        this.actionMap = actions;
    }

    public State<Id, ?> getBegin(){
        return begin;
    }

    public State<Id, ?> getEnd() {
        return end;
    }

    public State<Id, ?> getState(Id id){
        return stateMap.get(id);
    }

    public Action<Id, ?, ?, ?> getAction(Id state, Id method){
        return actionMap.get(Pair.of(state, method));
    }

    @Override
    public  MachineInstance<Id, ?> newInstance(StateInstance<Id, ?> args) {
        return new MachineInstance<>(this, args);
    }

    public static class Builder<Id> {
        private Map<Id, State<Id, ?>> stateMap;
        private Id begin;
        private Id end;
        private Map<Pair<Id, Id>, Action<Id, ?, ?, ?>> actionMap;
        private Generator<Id> idGenerator;


        public Builder(Generator<Id> generator){
            this.idGenerator = generator;
        }

        public Id addState(Id id){
            id = idGenerator.regenerate(id);
            stateMap.put(id, new State<>(id));
            return id;
        }

        public Builder<Id> setBegin(Id id){
            this.begin = id;
            return this;
        }

        public Builder<Id> setEnd(Id id){
            this.end = id;
            return this;
        }

        public Builder<Id> addAction(Id state, Id method, Action<Id, ?, ?, ?> action){
            actionMap.put(Pair.of(state, method), action);
            return this;
        }

        public Machine<Id> build(){
            return new Machine<>(begin, end, stateMap, actionMap);
        }
    }
}
