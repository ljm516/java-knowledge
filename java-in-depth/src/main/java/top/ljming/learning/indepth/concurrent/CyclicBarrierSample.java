package top.ljming.learning.indepth.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏，多线程并发控制工具.
 * 和CountDownLatch类似，但是计数器可以反复使用。
 *
 * @author lijm
 */
public class CyclicBarrierSample {

    static int nums = 10;
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(nums, new BarrierAction(false, nums));

    public static void main(String[] args) {
        for (int i = 0; i < nums; i++) {
            Thread thread = new Thread(new Task("task[" + i + "]", cyclicBarrier));
            thread.start();
            if (i == 5) {
                thread.interrupt();
            }
        }
    }

    public static class Task implements Runnable {
        String taskName;
        final CyclicBarrier cyclicBarrier;

        public Task(String taskName, CyclicBarrier cyclicBarrier) {
            this.taskName = taskName;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await(); // 进入等待，直到所有的线程都准备完成，完成一次计数。
                Thread.sleep(1000);
                System.out.println(taskName + " over, time=[" + System.currentTimeMillis() + "]");
                cyclicBarrier.await(); // 再次进入等待，进入下一次计数
            } catch (InterruptedException | BrokenBarrierException e) {
                // 如果一个线程发生中断，将会抛出interruptedException，其它将会抛出BrokerBarrierException。
                // 因为如果其中一个线程出现问题，表示CyclicBarrier已经破损了，无法等到所有线程到齐，如果继续等待，是徒劳的。
                e.printStackTrace();

            }
        }
    }

    public static class BarrierAction implements Runnable {
        boolean flag;
        int n;

        public BarrierAction(boolean flag, int n) {
            this.flag = flag;
            this.n = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("[" + n + "] 个task全部完成");
            } else {
                System.out.println("[" + n + "] 个task准备完成");
                flag = true;
            }
        }
    }
}
