package top.ljming.javaindepth.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 倒计数器.
 *
 * @author lijm
 */
public class CountDownLatchSample {
    static int threadNums = 10;
    static CountDownLatch countDownLatch = new CountDownLatch(threadNums); // 构造函数，计数器为10，表示需要10个线程完成任务后等待在countdownLatch的线程才能继续执行


    public static void main(String[] args) throws InterruptedException {
        demo();
        System.out.println("start: " + System.currentTimeMillis());
        countDownLatch.await(11000, TimeUnit.MILLISECONDS);
        System.out.println("end: " + System.currentTimeMillis());
        System.out.println("over");

        countDownLatch = new CountDownLatch(threadNums);
        demo();
        System.out.println("start again: " + System.currentTimeMillis());
        countDownLatch.await(11000, TimeUnit.MILLISECONDS);
        System.out.println("end again: " + System.currentTimeMillis());
        System.out.println("over again");
    }

    private static void demo() {
        for (int i = 0; i < threadNums; i++) {
            Thread t = new Thread(new Task(i));
            t.start();
        }
    }

    private static class Task implements Runnable {
        int no;
        Task(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            try {
                long sleep = 2000;
                Thread.sleep(sleep);
//                if (no == 5) {
//                    throw new RuntimeException("test exception not countDown");
//                }
                System.out.println(Thread.currentThread().getName() + " finished");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
