package com.javaReview.mianshi;

import java.util.Random;

/**
 * Created by jiangmingli on 2017/11/14.
 * 场景：一个领券入口，有 100，50，40 这三种券，概率分别是0.1, 0.5, 0.4。
 * 设计一个这样的算法
 */
public class RandomRate {

    public static void random() {
        int[] arr = {100, 50, 50, 50, 50, 50, 40, 40, 40,40};
        int hundredTime =  0;
        int fiftyTime =  0;
        int fortyTime =  0;
        for (int k = 0; k < 10000; k++){
            int i = new Random().nextInt(10);
            if (arr[i] == 100) {
                hundredTime ++;
            }
            if (arr[i] == 50) {
                fiftyTime ++;
            }
            if(arr[i] == 40) {
                fortyTime ++;
            }
            System.out.println("index: " + i + "return: " + arr[i]);
        }


        System.out.println("hundred: " + hundredTime + " fifty: " + fiftyTime + " forty: " + fortyTime);
    }

    public static void main(String[] args) {
        random();
    }

    public static int[] changeRate(Rate hundred, Rate fifty, Rate forty) {
        int[] originArray = new int[10];
        int hundredCount = new Double(hundred.rate * 10).intValue();
        int fiftyCount = new Double(fifty.rate * 10).intValue();
        int fortyCount = new Double(forty.rate * 10).intValue();



        return null;
    }
}
