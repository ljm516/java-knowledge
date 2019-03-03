package com.javaReview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by jiangmingli on 2017/10/20.
 */
public class CallableThread implements Callable<Integer> {

    public static void main(String[] args) {
        CallableThread callableThread = new CallableThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callableThread);
        new Thread(futureTask, "有返回值的线程").start();
        try {
            System.out.println("子线程的返回值: " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
