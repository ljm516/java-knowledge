package top.ljming.learning.indepth.thread;

/**
 * 线程优先级.
 *
 * @author lijm
 */
public class ThreadPriority {

    private static Object obj = new Object();
    private static double lowFaster = 0;
    private static double highFaster = 0;
    private volatile static long lowFinishTime = 0;
    private volatile static long highFinishTime = 0;
    public static void main(String[] args) throws InterruptedException {
        int runTimes = 100;
        for (int i = 0; i < runTimes; i++) {
            PriorityThread high = new PriorityThread();
            high.setPriority(Thread.MAX_PRIORITY);
            high.setName("highPriorityThread");

            PriorityThread low = new PriorityThread();
            low.setPriority(Thread.MIN_PRIORITY);
            low.setName("lowPriorityThread");

            low.start();
            high.start();

            low.join();
            high.join();

            // 记录不同优先级先完成的次数，然后作对比
            if (lowFinishTime - highFinishTime > 0) {
                lowFaster ++;
            } else {
                highFaster ++;
            }
        }

        System.out.println(lowFaster / runTimes);
        System.out.println(highFaster / runTimes);
    }

    static class PriorityThread extends Thread {
        static int count = 0;

        @Override
        public void run() {
            while (count > 10000) {
                synchronized (obj) {
                    count++;
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished job");
            // 简单的记录完成jod的时间点
            if (Thread.currentThread().getName().equalsIgnoreCase("lowPriorityThread")) {
                lowFinishTime = System.currentTimeMillis();
            } else {
                highFinishTime = System.currentTimeMillis();
            }
        }
    }
}
