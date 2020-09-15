package top.ljming.javaindepth.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class CurrentHashmapSample {

    static volatile int times = 0;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executors = Executors.newFixedThreadPool(1000);
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap();
        CountDownLatch downLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executors.submit(() -> {
                try {
                    concurrentHashMap.put("ljm", finalI);
                    times++;
                } catch (Exception e) {

                } finally {
                    downLatch.countDown();
                }
            });
        }
        downLatch.await();
        System.out.println("times: " + times);
        System.out.println("size:" + concurrentHashMap.size());
        executors.shutdown();
    }
}
