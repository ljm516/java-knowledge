package com.javaReview.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangmingli on 2017/10/10.
 */
public class HashCodeTest {


    public static void main(String[] args) {
//        String s1 = "hello world";
//        String s2 = "hello world";
//        String s3 = new String("hello world");
//        System.out.println(s1.hashCode() + "\n" + s2.hashCode() + "\n" + s3.hashCode());
//        System.out.println(s1.equals(s2));
//        System.out.println(s2.equals(s3));
//
//        System.out.println(s1 == s2);
//        System.out.println(s2 == s3);
        int[] arr = {1, 2, 1, 3, 2, 5};
        single_number(arr);
    }

    public static int[] single_number(int[] nums) {
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (intMap.containsKey(nums[i])){
                intMap.put(nums[i], intMap.get(nums[i]) + 1);
            }else {
                intMap.put(nums[i], 1);
            }
        }
        List<Integer> intList = new ArrayList<>();
        for (Map.Entry e : intMap.entrySet()) {
            if ((Integer)e.getValue() == 1){
                intList.add((Integer)e.getKey());
            }
        }
        int[] arr = new int[intList.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = intList.get(i);
        }
        return arr;
    }

}
