package top.ljming.learning.indepth.collection;

import java.util.*;

/**
 * 深入了解List集合.
 *
 * @author lijm
 */
public class ListClassInDeep<T> {

    // ArrayList的ConcurrentModificationException
    public void arrayListConcurrentModifyException(List<T> arrList) {
        Runnable task1 = () -> {
            Integer i = 100;
            while (i > 0) {
                arrList.add((T) i);
                i--;
            }
        };
        Runnable task2 = () -> {
            for (T t : arrList) {
                System.out.println(t);
            }
        };
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    // ArrayList错误的remove某个元素
    public void arrayListUnSafeRemove(List<T> arrList) {
        for (T t: arrList) {
            arrList.remove(t);
        }
    }

    // 安全地移除ArrayList中的某个元素
    public void arrayListSafeRemove(List<T> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            arrList.remove(arrList.get(i));
        }
    }

    public void knowLinkedList(LinkedList<T> linkList) {

    }

}
