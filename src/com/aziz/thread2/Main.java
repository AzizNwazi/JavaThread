package com.aziz.thread2;

//Example, implements Runnable

public class Main {
    public static void main(String[] args) {


        Thread printer1 = new Thread(new Printer("Printer1"));
        Thread printer2 = new Thread(new Printer("Printer2"));

        printer1.start();
        printer2.start();


    }



}
