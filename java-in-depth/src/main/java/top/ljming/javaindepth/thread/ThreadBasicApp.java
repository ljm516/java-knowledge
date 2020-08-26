package top.ljming.javaindepth.thread;

/**
 * 线程创建.
 *
 * @author lijm
 */
public class ThreadBasicApp {

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("hello + " + Thread.currentThread().getName());
            }
        };
        t.start();
    }

    public class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("hello " + Thread.currentThread().getName());
        }
    }
}
