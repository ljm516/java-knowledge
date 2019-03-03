package com.javaReview.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiangmingli on 2017/11/7.
 */
public class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    // 通过lock生成一个与之绑定的Condition对象
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            // 要求线程在condition对象上进行等待
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition tl = new ReenterLockCondition();
        Thread t1 = new Thread(tl);
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        // 告知等待的Condition上的线程可以继续执行了
        condition.signal();
        lock.unlock();
    }
}
