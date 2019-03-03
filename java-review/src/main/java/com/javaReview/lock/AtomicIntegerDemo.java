package com.javaReview.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiangmingli on 2017/11/8.
 */
public class AtomicIntegerDemo {

    static AtomicInteger i = new AtomicInteger();
    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int k = 0; k < 100; k++) {
                i.incrementAndGet(); //使用cas指令加1，同时返回当前值
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread());
        }

        for (int k = 0; k < 10; k++) {ts[k].start();}
        for (int k = 0; k < 10; k++) {ts[k].join();}

        System.out.println(i);
    }
}
