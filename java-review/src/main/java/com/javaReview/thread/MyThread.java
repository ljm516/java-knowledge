package com.javaReview.thread;

/**
 * Created by jiangmingli on 2017/10/20.
 */
public class MyThread extends Thread {

    public static int a = 10;

    public void run(){
        a++;
        System.out.println(a);
    }

    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        try {

            thread2.start();
//            thread2.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
