package top.ljming.javaindepth.concurrent;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class ThreadLocalMapTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            ThreadLocalMapSample.set("hello " + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + "over");
            System.out.println(ThreadLocalMapSample.get() + "\n");
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);
        Thread t5 = new Thread(task);
        Thread t6 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();

        System.out.println("over");
    }
}
