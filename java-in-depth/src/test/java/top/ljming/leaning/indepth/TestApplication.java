/*
 * Copyright (C) 2018 www.missfresh.cn All rights reserved.
 *
 * Created by lijm on 2019/4/14.
 */

package top.ljming.leaning.indepth;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * test.
 *
 * @author lijm
 */
public class TestApplication {

    @Test
    public void test() {
        System.out.println("test application");
    }

    @Test
    public void test1() {
        Object obj = 1.234;
        System.out.println(obj instanceof Number);
    }

    @Test
    public void testCountDown() {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService service = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        try {
            System.out.println("start: " + start);
            for (int i = 0; i < 100; i++) {
                service.submit(() -> {
                    try {
                        testa();
                        System.out.println("-----------------");
                    } catch (Exception e) {
                        System.err.println("exception");
                    } finally {
                        latch.countDown();
                    }

                });
            }
            System.out.println(latch.await(5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            latch.countDown();
            e.printStackTrace();
        }
        System.out.println("main over, end=" + (System.currentTimeMillis() - start));
    }

    public void testa() {
        System.out.println("threadname: " + Thread.currentThread().getName());
        throw new RuntimeException();
    }

    @Test
    public void testFormat() {
        String sv = "3.0000000";
        double v = Double.parseDouble(sv);

        DecimalFormat format = new DecimalFormat("0.00");
        System.out.println(format.format(v));
    }

    @Test
    public void testDate() {
        long current = System.currentTimeMillis();
        long before365 = current - 86400 * 365 * 1000L;
        System.out.println(new Date(before365));
    }

    @Test
    public void testSortSet() {
        SortedSet<BigDecimal> sortedRate = new TreeSet<>();
        sortedRate.add(BigDecimal.valueOf(1));
        sortedRate.add(BigDecimal.valueOf(5));
        sortedRate.add(BigDecimal.valueOf(3));
        sortedRate.add(BigDecimal.valueOf(6));

        System.out.println(sortedRate.first() + ", " + sortedRate.last());
    }
}
