package top.ljming.learning.indepth.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁.
 *
 * @author lijm
 */
public class ReentrantLockSample {
    private static ReentrantLock lock = new ReentrantLock();
    private static int nums = 0;


    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    private static ReentrantLock fairLock = new ReentrantLock(true); // 默认为非公平锁，true表示为公平锁

    public static void main(String[] args) throws InterruptedException {
        //demo();

        //lockInterrupt();

        //tryLock();

        fairLock();

    }

    private static void demo() throws InterruptedException {
        DemoTask task = new DemoTask();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(nums);
    }

    // 简单的ReentrantLock使用
    public static class DemoTask implements Runnable {

        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取到锁");
            try {
                for (int i = 0; i < 10000; i++) {
                    nums++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放锁");
            }
        }
    }

    private static void lockInterrupt() throws InterruptedException {
        LockInterruptTask lock1 = new LockInterruptTask(1);
        LockInterruptTask lock2 = new LockInterruptTask(2);

        Thread t1 = new Thread(lock1);
        Thread t2 = new Thread(lock2);

        t1.start();
        t2.start();

        Thread.sleep(1000);

        t2.interrupt();

    }

    // 线程竞争锁，中断响应
    public static class LockInterruptTask implements Runnable {

        int lock;

        public LockInterruptTask(int lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                if (lock == 1) {
                    lock1.lockInterruptibly();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock2.lockInterruptibly();
                } else {
                    lock2.lockInterruptibly();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock1.lockInterruptibly();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                    System.out.println("lock1 释放");
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                    System.out.println("lock2 释放");
                }

            }
            System.out.println(Thread.currentThread().getName() + "finished");
        }
    }

    private static void tryLock() throws InterruptedException {
        TryLockTask tryLockTask1 = new TryLockTask();
        TryLockTask tryLockTask2 = new TryLockTask();
        Thread t1 = new Thread(tryLockTask1);
        Thread t2 = new Thread(tryLockTask2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    // 锁申请等待限时
    public static class TryLockTask implements Runnable {
        int i = 0;

        @Override
        public void run() {
            try {
                // lock.tryLock()可以不带参数的获取锁，如果能获取锁成功，返回true，如果失败，立即返回false，不会导致线程等待
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    while (i < 100) {
                        i++;
                    }
                    Thread.sleep(6000);
                }
                System.out.println(Thread.currentThread().getName() + "finished, i=" + i + ", time=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放锁");
                }
            }
        }
    }

    private static void fairLock() throws InterruptedException {
        FairLockTask fairLockTask = new FairLockTask();
        Thread t1 = new Thread(fairLockTask);
        Thread t2 = new Thread(fairLockTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static class FairLockTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    fairLock.lock();
                    System.out.println(Thread.currentThread().getName() + "获取到锁");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    fairLock.unlock();
                }
            }
        }
    }

    public static void method() throws InterruptedException {

        lock.lock(); // 获取锁，如果没有获取成功，则进入等待
        lock.unlock(); // 释放锁，需要事先获取到锁
        lock.lockInterruptibly(); // 可中断的获取锁，需要接收一个中断通知
        boolean result= lock.tryLock(); // 尝试获取锁，获取成功返回true，失败立即返回false，不进行等待
        boolean waitReuslt = lock.tryLock(1000, TimeUnit.MILLISECONDS); // 带时间的尝试，获取失败，等待指定时间

        lock.isLocked(); // 判断该锁失败是锁定状态，state!=0
        lock.isHeldByCurrentThread(); // 判断锁是否被当前线程持有 exclusiveOwnerThread == Thread.currentThread
        lock.getHoldCount(); // 锁进入的次数，获取的是state的值，每进入一次，state+1
        boolean fair = lock.isFair(); // 是否为公平锁
    }
}
