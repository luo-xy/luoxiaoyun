package com.example.shiro;

public class Lanhan {
    private Lanhan(){}
    private static Lanhan lh;
    public static Lanhan getInstance(){
        if (lh==null){
            lh=new Lanhan();
        }
        return lh;
    }

}
