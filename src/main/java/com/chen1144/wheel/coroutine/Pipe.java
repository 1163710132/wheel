package com.chen1144.wheel.coroutine;


import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;
import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.collection.List;
import io.vavr.control.Either;

public class Pipe<In, Out> implements Function1<In, Out> {
    private List<Function1> list;
    private List<Function1> reversed;

    private Pipe(List<Function1> list, List<Function1> reversed){
        this.list = list;
        this.reversed = reversed;
    }

    public static void main(String[] args) {
        Pipe<Void, Integer> pipe = Pipe.ofValue(0);
        for(int i = 0;i < 1000000;i++){
            pipe = pipe.pushBack(j -> j + 1);
        }
        System.out.println(pipe.apply(null));
    }

    public static <In, Out> Pipe<In, Out> ofFunction(Function1<In, Out> function1){
        return new Pipe<>(List.of(function1), null);
    }

    public static <Out> Pipe<Void, Out> ofSupplier(Function1<Void, Out> supplier){
        return new Pipe<>(List.of(supplier), null);
    }

    public static <Out> Pipe<Void, Out> ofValue(Out value){
        return new Pipe<>(List.of(aVoid -> value), null);
    }

    @Override
    public Out apply(In in) {
        Object value = in;
        for(var function1 : getList()){
            value = function1.apply(value);
        }
        return (Out)value;
    }

    public Either<Out, Exception> tryApply(In in){
        try{
            return Either.left(apply(in));
        }catch (Exception e){
            return Either.right(e);
        }
    }

    private List<Function1> getList(){
        if(list == null){
            list = reversed.reverse();
        }
        return list;
    }

    private List<Function1> getReversed(){
        if(reversed == null){
            reversed = list.reverse();
        }
        return reversed;
    }

    public <In2> Pipe<In2, Out> pushFront(Function1<In2, In> function1){
        return new Pipe<>(getList().push(function1), null);
    }

    public <Out2> Pipe<In, Out2> pushBack(Function1<Out, Out2> function1){
        return new Pipe<>(null, getReversed().push(function1));
    }
}
