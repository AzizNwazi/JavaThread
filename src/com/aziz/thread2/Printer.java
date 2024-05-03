package com.aziz.thread2;

public class Printer implements Runnable{

    private  String isim;

    public Printer(String isim) {
        this.isim = isim;
    }

    @Override
    public void run() {
        System.out.println(isim+" is working");
        for(int i=1 ; i<= 10;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread error ...");
            }
        }
        System.out.println(isim+" is Done");
    }
}
