package top.ljming.learning.indepth.concurrent;

import lombok.Data;

/**
 * 线程终止的错误示范.
 *
 * @author lijm
 */
public class ThreadStopErrorSample {

    private static User user = new User();

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            Thread t =  new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            t.stop(); // Thread.stop()方法在结束线程时，会直接终止线程，并且会立即释放这个线程所持有的锁。
        }
    }

    private static class ChangeObjectThread extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    long v = System.currentTimeMillis() / 1000;
                    user.setName(String.valueOf(v));

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setId(v);
                }
                Thread.yield();
            }
        }
    }

    private static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    @Data
    private static class User {
        private long id;
        private String name;

        User() {
            id = 0;
            name = "0";
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
