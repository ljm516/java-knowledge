package top.ljming.learning.indepth.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int i = 1;

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        DescreaseThread descreaseThread = new DescreaseThread();

        addThread.run();
        descreaseThread.run();

        while (true) {
            if (i > 10) {
                System.out.println("enter await");
                condition.await();
            }
            System.out.println("i: " + i);
        }
    }

    static class AddThread implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                i++;
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    static class DescreaseThread implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                i--;
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }
}
