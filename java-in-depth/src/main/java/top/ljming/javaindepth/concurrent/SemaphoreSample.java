package top.ljming.javaindepth.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 允许多个线程同时访问:信号量.
 *
 * @author lijm
 */
public class SemaphoreSample {

    static Semaphore semaphore = new Semaphore(5);
    static int threadNums = 20;
    static CountDownLatch countDownLatch = new CountDownLatch(threadNums);

    public static void main(String[] args) throws InterruptedException {
        demo();

        countDownLatch.await();
    }

    public static void demo() {
        for (int i = 0; i < threadNums; i++) {
            Thread thread = new Thread(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "finished, time=" + System.currentTimeMillis());
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
            thread.start();
        }
    }


    public void method() throws InterruptedException {
        semaphore = new Semaphore(10); // 构造函数，指定可进入的线程数
        semaphore = new Semaphore(10, true); // 构造函数，指定可进入的线程数，且是否为公平

        semaphore.acquire(); // 尝试获取一个准入许可，如无法获取，则线程进入等待，直到有线程释放一个许可或者当前线程被中断
        semaphore.acquireUninterruptibly(); // 和acquire方法类似，但是不响应中断
        semaphore.tryAcquire(); // 尝试获取一个准入许可，如果成功则返回true，失败返回false，不会进行等待，立即返回
        semaphore.tryAcquire(100, TimeUnit.MILLISECONDS); // 和tryAcquire相同，但是带有时间的等待
        semaphore.release(); // 用于线程在访问资源结束后释放一个许可
    }
}
