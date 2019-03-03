package com.javaReview.thread;

import java.util.concurrent.*;

/**
 * Created by jiangmingli on 2017/10/23.
 */
public class ExecutorCase {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Future<String> future = executorService.submit(new Task());
        System.out.println("do other things");

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            try{
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "this is future case";
        }
    }
}
