package com.javaReview.thread;

import java.util.concurrent.*;

/**
 * Created by jiangmingli on 2017/10/20.
 */
public class ThreadPool {

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++){
            executorService.execute(new Task());

        }
        executorService.shutdown();
    }


    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("当前线程: " + Thread.currentThread().getName());
        }
    }
}
