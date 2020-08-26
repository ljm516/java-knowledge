package top.ljming.javaindepth.concurrent;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ArrayList出现ConcurrentModificationException的一个测试.
 *
 * @author lijm
 */
public class ConcurrentModificationExceptionSample {

    private static List<Something> somethingList = new ArrayList<>();

    private void init() {
        /*
          以下代码在多线程的环境下就可能出现ConcurrentModificationException。
          共享变量somethingList在进行sort的时候，就有存在其他线程对somethingList执行了clear操作。
          这时候 modCount 属性发生了变化，导致进行sort的时候，
          发现modCount!=expectedModCount,从而抛出ConcurrentModificationException
        */
        somethingList.clear();
        for (int i = 0; i < 10; i++) {
            Something something = new Something();
            something.setId(i);
            something.setStr(String.valueOf(i));

            somethingList.add(something);
        }
        somethingList.sort(Comparator.comparingInt(Something::getId));
    }


    public static void main(String[] args) {

        ConcurrentModificationExceptionSample sample = new ConcurrentModificationExceptionSample();
        // 起1000个线程对sample实例进行操作
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new SampleThread(sample));
            thread.start();
        }

    }

    @Data
    private class Something {
        private Integer id;
        private String str;
    }

    private static class SampleThread implements Runnable {

        private ConcurrentModificationExceptionSample sample;

        SampleThread(ConcurrentModificationExceptionSample sample) {
            this.sample = sample;
        }
        @Override
        public void run() {
            System.out.println("current thread : " + Thread.currentThread().getName());
            sample.init();
        }
    }
}
