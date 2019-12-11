package top.ljming.learning.indepth.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ExecutorsSample {

    private static volatile int nums = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableTask());
        }
        executorService.shutdown();
    }

    public static void submitRunnableTask() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<?>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<?> future = executorService.submit(new RunnableTask());
            futureList.add(future);
        }
        countDownLatch.await();
        for (Future<?> future : futureList) {
            try {
                System.out.println("runnableTask future: " + future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    private static void submitCallableTask() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<?>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<?> future = executorService.submit(new CallableTask());
            futureList.add(future);
        }
        countDownLatch.await();
        for (Future<?> future : futureList) {
            try {
                System.out.println("callableTask future: " + future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    static class RunnableTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finished,time=" + System.currentTimeMillis() / 1000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CallableTask implements Callable<Integer> {
        @Override
        public Integer call() {
            try {
                lock.lock();
                for (int i = 0; i < 100; i++) {
                    nums++;
                }
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return nums;
        }
    }

    private static void scheduleAtFixedRate() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new RunnableTask(), 1000, 2000, TimeUnit.MILLISECONDS);
    }

    private static void scheduleWithFixedDelay() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new RunnableTask(), 1000, 2000, TimeUnit.MILLISECONDS);
    }

    private static void cacheThreadDemo() {
        ExecutorService executorService = Executors.newCachedThreadPool();

    }

    public static void main(String[] args) {
        //submitCallableTask();
        System.out.println("current time: " + System.currentTimeMillis() / 1000);
        scheduleWithFixedDelay();
    }
    public static void method() {
        Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(10);
        Executors.newSingleThreadScheduledExecutor();
    }



}
