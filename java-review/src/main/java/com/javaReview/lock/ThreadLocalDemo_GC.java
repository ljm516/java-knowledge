package com.javaReview.lock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiangmingli on 2017/11/8.
 */
public class ThreadLocalDemo_GC {

    static volatile ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>() {
        protected void finalize() {
            System.out.println(this.toString() + " is gc");
        }
    };

    static volatile CountDownLatch cd = new CountDownLatch(100);

    public static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (tl.get() == null) {
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
                        protected void finalize() throws Throwable {
                            System.out.println(this.toString() + " is gc");
                        }
                    });
                    System.out.println(Thread.currentThread().getId() + ": create SimpleDateFormat");
                }
                Date t = tl.get().parse("2017-11-08 14:43:" + i % 60);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                cd.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            es.execute(new ParseDate(i));
        }
        cd.await();
        System.out.println("mission complete !!");
        tl = null;
        System.gc();
        System.out.println("first GC complete !!");

        tl = new ThreadLocal<SimpleDateFormat>();
        cd = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            es.execute(new ParseDate(i));
        }
        cd.await();
        Thread.sleep(1000);
        System.gc();
        System.out.println("second gc complete !!");
        es.shutdownNow();
    }
}
