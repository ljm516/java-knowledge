package top.ljming.learning.indepth.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class VolatileDemo {

    private static volatile int i;
    static CountDownLatch countDownLatch = new CountDownLatch(10);
    private static final Object lock = new Object();

    private static Object instance;

    public static void main(String[] args) throws InterruptedException {

        for (int j = 0; j < 10; j++) {
            Thread thread = new Thread(() -> add());
            thread.start();
        }
        countDownLatch.await();
        System.out.println(i);
    }

    public static void add() {
        i++;
    }


    public static Object getInstance() {
        if (null == instance) {
            synchronized (lock) {
                if (null == instance) {
                    instance = new Object();
                }
            }
        }
        return instance;
    }
}
