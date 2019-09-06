package com.chen1144.wheel.coroutine;

import com.chen1144.wheel.util.Timer;
import io.vavr.Function1;

import java.util.Iterator;
import java.util.Optional;

public class LockedChannel<T> implements Channel<T> {
    private T ref;
    private boolean hasValue;
    private boolean terminated;

    LockedChannel(){
        hasValue = false;
        terminated = false;;
        ref = null;
    }

    public static void main(String[] args) {
        long time = Timer.timing(()->{
            Iterable<Integer> iterable = Iterables.fromFunction(yieldYield ->{
                for(int i = 0;i < 10;i++){
                    yieldYield.ret(i);
                }
                yieldYield.brk();
                return null;
            });
            for(int i : iterable){
                System.out.println(i);
            }
            System.out.println("finished");
            return null;
        });
        System.out.println(time);
    }

    @Override
    public void ret(T value){
        while (true){
            synchronized (this){
                if(!hasValue){
                    ref = value;
                    hasValue = true;
                    break;
                }
            }
            Thread.yield();
        }
    }

    @Override
    public void brk(){
        while (true){
            synchronized (this){
                if(!hasValue){
                    ref = null;
                    terminated = true;
                    break;
                }
            }
            Thread.yield();
        }
    }

    @Override
    public Optional<T> readNext() {
        while (true){
            synchronized (this){
                if(hasValue){
                    hasValue = false;
                    return Optional.of(ref);
                }else if(terminated){
                    return Optional.empty();
                }
            }
            Thread.yield();
        }
    }

//    public static class YieldIterator<T> implements Iterator<T> {
//        private final LockedChannel<T> yieldYield;
//
//        public YieldIterator(LockedChannel<T> yieldYield){
//            this.yieldYield = yieldYield;
//        }
//
//        @Override
//        public boolean hasNext() {
//            while (true){
//                synchronized (yieldYield){
//                    if(yieldYield.hasValue){
//                        return true;
//                    }else if(yieldYield.terminated){
//                        return false;
//                    }
//                }
//                Thread.yield();
//            }
//        }
//
//        @Override
//        public T next() {
//            synchronized (yieldYield){
//                if(yieldYield.hasValue){
//                    T ref = yieldYield.ref;
//                    yieldYield.hasValue = false;
//                    return ref;
//                }
//                throw new RuntimeException();
//            }
//        }
//    }
}
