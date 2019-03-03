package com.javaReview.thread;

/**
 * Created by jiangmingli on 2017/10/20.
 */
public class MyRunable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 3) {
                MyRunable runable = new MyRunable();
                new Thread(runable, "new Thread-1").start();
                new Thread(runable, "new Thread-2").start();

            }
        }

    }
}
