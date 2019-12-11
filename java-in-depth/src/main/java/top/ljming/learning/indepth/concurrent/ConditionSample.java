package top.ljming.learning.indepth.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁的好搭档: Condition.
 *
 * @author lijm
 */
public class ConditionSample {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int i = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread addThread = new Thread(new AddTask());
        addThread.start();

        Thread.sleep(2000);

        lock.lock();
        condition.signal();
        lock.unlock(); // 执行了condition.signal之后，需要释放锁，否则其它线程虽然被唤醒，但是仍然获取不到锁

        addThread.join();

        System.out.println(i);
    }

    static class AddTask implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                while (i < 10000) {
                    i++;
                    if (i == 10) {
                        System.out.println(Thread.currentThread().getName() + "进入等待");
                        condition.await();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void conditionMethod() throws InterruptedException {
        // 使的当前线程等待，并释放锁，等待其它线程使用signal方法或者signalAll方法时，线程会重新获得锁并继续执行。或者当线程被中断时，也能跳出等待
        condition.await();
        // 使的当前线程等待，并释放锁，带有时间的等待，时间一过，继续执行
        condition.await(500, TimeUnit.MILLISECONDS);
        // 用于唤醒一个在等待中的线程
        condition.signal();
        // 用户唤醒所有在等待的线程
        condition.signalAll();
        // 和await方法相同，但是不会在等待过程中响应中断
        condition.awaitUninterruptibly();
    }
}
