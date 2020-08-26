package top.ljming.javaindepth.thread;

/**
 * Object的wait和notify方法.
 *
 * @author lijm
 */
public class ThreadWaitAndNotify {

    private static Object obj = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                System.out.println("t1 get object lock: " + System.currentTimeMillis());
                try {
                    obj.wait();
                    System.out.println("t1 end: " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                System.out.println("t2 get object lock: " + System.currentTimeMillis());
                obj.notify();
                try {
                    System.out.println("t2 end: " + System.currentTimeMillis());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }
}

