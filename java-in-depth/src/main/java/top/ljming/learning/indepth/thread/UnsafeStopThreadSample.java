package top.ljming.learning.indepth.thread;

import lombok.Data;

/**
 * 描述线程的不正常退出：stop方法.
 *
 * @author lijm
 */
public class UnsafeStopThreadSample {
    static User user = new User();

    public static void main(String[] args) throws InterruptedException {
        Thread readThread = new Thread(new ReadTask());
        readThread.start();
        while (true) {
            WriteThread writeThread = new WriteThread();
            writeThread.start();
            Thread.sleep(150);
            writeThread.stopMe();
        }
    }

    public static class ReadTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getAge() != Integer.parseInt(user.getName())) {
                        System.out.println("age: " + user.getAge() + ";name:" + user.getName());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static class WriteThread extends Thread {

        // 正确的停止一个线程的方法
        volatile boolean stop = false;
        public void stopMe() {
            stop = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stop) {
                    System.out.println("Thread-" + Thread.currentThread().getName() + " exit");
                }
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    user.setAge(v);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }
    @Data
    public static class User {
        int age;
        String name;

        public User() {
            this.age = 0;
            this.name = "0";
        }
    }
}
