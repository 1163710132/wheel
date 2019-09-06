package com.chen1144.wheel.util;

public class Booleans {
    public enum Of2{
        FF, FT, TF, TT
    }
    public enum Of3{
        FFF, FFT, FTF, FTT, TFF, TFT, TTF, TTT
    }

    static public Of2 from(boolean b1, boolean b2){
        if(b1){
            if(b2){
                return Of2.TT;
            }else{
                return Of2.TF;
            }
        }else{
            if(b2){
                return Of2.FT;
            }else{
                return Of2.FF;
            }
        }
    }
}
