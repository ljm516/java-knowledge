package com.javaReview.map;

import javax.lang.model.type.ExecutableType;
import java.util.Currency;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiangmingli on 2017/10/21.
 */
public class MyHashMap {

    static Map<String, Integer> map = new HashMap();
    static String s1 = new String("柳柴");
    static String s2 = new String("柴柕");
    static String s3 = new String("hello");

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        executorService.execute(new Thread());
        executorService.execute(new Thread());
        executorService.shutdown();
    }


    static class Thread implements Runnable {

        @Override
        public void run() {
            System.out.println("当前线程: " + java.lang.Thread.currentThread().getName());
            map.put(s3, new Integer(1001));
            map.put(null, null);
            System.out.println(map.size());
        }
    }
}
