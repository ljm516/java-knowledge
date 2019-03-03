package com.javaReview.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by jiangmingli on 2017/11/13.
 */
public class ThreadTest implements Callable {


    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(new ThreadTest());
        System.out.println(future.get());
    }

    @Override
    public Integer call() throws Exception {
        return 1;
    }
}
