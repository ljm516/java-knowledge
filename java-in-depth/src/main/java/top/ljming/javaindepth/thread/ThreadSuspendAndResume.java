package top.ljming.javaindepth.thread;

/**
 * 线程的挂起和继续执行.
 *
 * @author lijm
 */
public class ThreadSuspendAndResume {

    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        /*
        ErrorSuspendAndResumeThread t1 = new ErrorSuspendAndResumeThread();
        ErrorSuspendAndResumeThread t2 = new ErrorSuspendAndResumeThread();
        t1.start();
        System.out.println("t1 start: " + System.currentTimeMillis());
        Thread.sleep(1000);
        t2.start();
        System.out.println("t2 start: " + System.currentTimeMillis());

        t1.resume();
        System.out.println("t1 resume: " + System.currentTimeMillis());
        t2.resume();
        System.out.println("t2 resume: " + System.currentTimeMillis());
        */

        GoodSuspendAndResumeThread t1 = new GoodSuspendAndResumeThread();
        GoodSuspendAndResumeThread t2 = new GoodSuspendAndResumeThread();
        t1.start();
        System.out.println("t1 start: " + System.currentTimeMillis());

        Thread.sleep(1000);

        t2.start();
        System.out.println("t2 start: " + System.currentTimeMillis());
        t1.suspendThread();

        t2.resumeThread();

        t1.resumeThread();
        System.out.println("t1 resume: " + System.currentTimeMillis());
        t2.suspendThread();
        System.out.println("t2 resume: " + System.currentTimeMillis());


    }

    static class ErrorSuspendAndResumeThread extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
                Thread.currentThread().suspend();
                System.out.println(Thread.currentThread().getName() + " suspend: " + System.currentTimeMillis());
            }
        }
    }

    static class GoodSuspendAndResumeThread extends Thread {

        private volatile boolean suspend = false;

        void suspendThread() {
            this.suspend = true;
        }

        void resumeThread() {
            suspend = false;
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " 通知");
                notify();
            }
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    while (suspend) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " 等待");
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName() + " 获取obj锁: " + System.currentTimeMillis());
                    }
                }
            }
        }
    }
}
