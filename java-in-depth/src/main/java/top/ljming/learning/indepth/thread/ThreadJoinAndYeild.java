package top.ljming.learning.indepth.thread;

/**
 * 等待线程结束和谦让.
 *
 * @author lijm
 */
public class ThreadJoinAndYeild {

    volatile static int i= 0;

    public static void main(String[] args) throws InterruptedException {
        AddThread t = new AddThread();
        t.start();

        // 如果在这里不执行join方法，输出的i可能是0或者是一个非常小的数
        t.join();
        System.out.println(i);
    }

    static class AddThread extends Thread {
        @Override
        public void run() {
            for (i=0; i < 10000; i++);
        }
    }
}
