package top.ljming.javaindepth.thread;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class SynchronizedLearn {

    static int num = 0;
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        AddTask task =  new AddTask();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("after: " + num);

    }

    static void add() {
        synchronized (lock) {
            for (int i = 0; i < 10000; i++) {
                num++;
            }
        }
    }

    static synchronized void synchronizeAdd() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
    }

    static class AddTask implements Runnable {

        private synchronized void add() {
            for (int i = 0; i < 10000; i++) {
                num++;
            }
        }

        @Override
        public void run() {
//            add();
            SynchronizedLearn.synchronizeAdd();
        }

    }

}
