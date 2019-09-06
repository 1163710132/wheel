package com.chen1144.wheel.util;

@FunctionalInterface
public interface ExceptionalRunnable {
    public void run() throws Exception;
    default Runnable toRunnable(){
        return ()->{
            try {
                run();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        };
    }
}
