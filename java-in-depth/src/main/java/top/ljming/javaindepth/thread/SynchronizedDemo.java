package top.ljming.javaindepth.thread;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class SynchronizedDemo {

    private int i;

//    private final Object o = new Object();

    public synchronized void sychAdd() {
        i++;
    }

    public void add() {
        synchronized (this) {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }

    }

    public String contact(String s1, String s2) {
        return s1 + s2;
    }

    public void demo() {
        for (int j = 0; j < 10000; j++) {
            synchronized (this) {
                i++;
            }
        }
    }

//    private void increase() {
//        synchronized (o) {
//            for (int j = 0; j < 10000; j++) {
//                i++;
//            }
//        }
//    }

//    public static void main(StringApp[] args) throws InterruptedException {
//        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
//        Task task = new Task(synchronizedDemo);
//
//        Thread t1 = new Thread(task);
//        Thread t2 = new Thread(task);
//
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(synchronizedDemo.i);
//    }
//
//    public static class Task implements Runnable {
//        SynchronizedDemo synchronizedDemo;
//
//        public Task(SynchronizedDemo synchronizedDemo) {
//            this.synchronizedDemo = synchronizedDemo;
//        }
//
//        @Override
//        public void run() {
//            synchronizedDemo.increase();
//        }
//    }

}
