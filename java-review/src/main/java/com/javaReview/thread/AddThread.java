package com.javaReview.thread;

/**
 * Created by jiangmingli on 2017/11/14.
 */
public class AddThread extends Thread {
    static int sum = 0;
    public void run() {
        for (sum = 0; sum < 1000; sum++) {

        }
    }

    public static void main(String[] args) throws Exception {
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join();
        System.out.println(sum);
    }
}
