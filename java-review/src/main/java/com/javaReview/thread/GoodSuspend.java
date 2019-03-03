package com.javaReview.thread;

/**
 * Created by jiangmingli on 2017/11/6.
 * 较好的线程挂起（suspend）和继续运行（resume）实现
 */
public class GoodSuspend {

    public static Object object = new Object();
    public static class ChangeObjectThread extends Thread {
        volatile boolean suspendMe = false;

        public void suspendMe() {
            suspendMe = true;
        }

        public void resumeMe() {
            suspendMe = false;
            synchronized (this) {
                notify();
            }
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    while (suspendMe) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    synchronized (object) {
                        System.out.println(" in ChangeObjectThread");
                    }
                    Thread.yield();
                }
            }
        }

    }
    public static class ReadObjectThread extends Thread {
        @Override
        public void run () {
            while (true) {
                synchronized (object) {
                    System.out.println("in ReadObjectThread");
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThread t1 = new ChangeObjectThread();
        ReadObjectThread t2= new ReadObjectThread();
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.suspendMe();
        System.out.println("suspend t1 2 sec");
        Thread.sleep(2000);
        System.out.println("resume t1");
        t1.resumeMe();
    }
}
