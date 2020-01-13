package top.ljming.learning.indepth.thread;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class VolatileSample {

    private static long count;

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);
        Thread t5 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println(count);


    }

    static class Task implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized (this) {
                    count++;
                }
            }
        }
    }
}
