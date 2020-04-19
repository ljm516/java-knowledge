package top.ljming.learning.indepth.dsa.leetcode;

import com.alibaba.fastjson.JSONObject;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class Gushi {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 6, 1, 4, 8};
        //gushi2(arr);
        gushi3(arr, 2);
    }

    public static void gushi1(int arr[]) {
        int maxBenefit = 0;
        int in = 0;
        int out = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int inValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int outValue = arr[j];
                int gap = outValue - inValue;
                if (gap > maxBenefit) {
                    maxBenefit = gap;
                    in = i;
                    out = j;
                }
            }
        }
        System.out.println("max=" + maxBenefit + ",in=" + in + ",out=" + out);
    }

    private static void gushi2(int arr[]) {
        int local = 0;
        int global = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            local = Math.max(local + arr[i + 1] - arr[i], 0);
            global = Math.max(local, global);
        }
        System.out.println(global);
    }

    private static void gushi3(int arr[], int times) {
        int[] local = new int[3];
        int[] global = new int[3];
        for (int i = 0;  i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            for (int j = times; j>=1; j--) {
                local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        System.out.println(JSONObject.toJSONString(global));
    }
}
