package multithreading;

import java.util.concurrent.TimeUnit;

public class T01_WhatIsThread {

    public static class T1 extends Thread{
        @Override
        public void run() {
            System.out.println("t1");
        }
    }
    public static class T2 implements Runnable{
        @Override
        public void run() {
            System.out.println("t2");
        }
    }
    public static void main(String[] args) {
        new T1().start();
        new Thread(new T2()).start();
        new Thread(()->{
            System.out.println("t3");
        }).start();
    }
}
