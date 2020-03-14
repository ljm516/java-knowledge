package top.ljming.learning.indepth.dsa.ms;

/**
 * 求第n大的数. 【车主邦】
 * 给出一个数组arr，和一个数n，返回第n大的数。例如：
 * arr=[3, 5, 1, 4, 6, 9, 8, -1] n=3
 * 返回6
 *
 * @author lijm
 */
public class LargestNumN {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1,-2,3,5,6};
        int n = 3;
        int resMax = Integer.MAX_VALUE;
        int preMax;
        while (n > 0) {
            preMax = arr[0];
            for (int anArr : arr) {
                if (preMax < anArr && anArr < resMax) {
                    preMax = anArr;
                }
            }
            if (resMax != preMax) {
                resMax = preMax;
            }
            n--;
        }
        System.out.println(resMax);
    }
}
