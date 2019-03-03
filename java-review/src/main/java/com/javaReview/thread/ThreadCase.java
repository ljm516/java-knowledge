package com.javaReview.thread;

import java.awt.*;

/**
 * Created by jiangmingli on 2017/11/6.
 * object wait() and notify()
 */
public class ThreadCase {
    final static Object object = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T1 start !");
                try {
                    System.out.println(System.currentTimeMillis() + ": T1 wait for object !");
                    object.wait(); // 会释放对象锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 end !");
            }
        }
    }

    public static class T2 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T2 start ! notify one thread");
                object.notify(); // 随机唤醒一个线程
                System.out.println(System.currentTimeMillis() + ": T2 end !");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
