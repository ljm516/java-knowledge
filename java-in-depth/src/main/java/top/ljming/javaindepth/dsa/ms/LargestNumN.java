package top.ljming.javaindepth.dsa.ms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 求第n大的数. 【车主邦】  经典topK问题
 * 给出一个数组arr，和一个数n，返回第n大的数。例如：
 * arr=[3, 5, 1, 4, 6, 9, 8, -1] n=3
 * 返回6
 *
 * @author lijm
 */
public class LargestNumN {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1, 4, 6, 9, 8, -1};
        int n = 3;
        int r = xiaoDingDui(arr, n);
        System.out.println(r);

        r = simple(arr, n);
        System.out.println(r);

    }

    private static int simple(int[] arr, int k) {
        int resMax = Integer.MAX_VALUE;
        int preMax;
        while (k > 0) {
            preMax = arr[0];
            for (int anArr : arr) {
                if (preMax < anArr && anArr < resMax) {
                    preMax = anArr;
                }
            }
            if (resMax != preMax) {
                resMax = preMax;
            }
            k--;
        }
        return resMax;
    }

    private static int xiaoDingDui(int[] arr, int k) {

        Queue<Integer> queue = new PriorityQueue<>(); // 优先队列构建小顶堆

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else if (arr[i] > queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int[] r = new int[queue.size()];
        int idx = 0;
        for (int n : queue) {
            r[idx++] = n;
        }

        return r[0];
    }
}
