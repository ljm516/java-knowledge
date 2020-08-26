package top.ljming.javaindepth.dsa.ms;

/**
 * 【逻辑思维】
 * 两个排好序的数组，然后合并一个新的排好序的大数组.
 *
 * @author lijm
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arrA = new int[]{0, 2, 3, 4, 7, 9, 10};
        int[] arrB = new int[]{1, 5, 6, 8};
        int[] arr = method2(arrA, arrB);
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int[] method(int[] arrA, int[] arrB) {
        int[] arr = new int[arrA.length + arrB.length];
        int aIndex = 0;
        int a = arrA[aIndex];

        int bIndex = 0;
        int b = arrB[bIndex];

        for (int index = 0; index <= arr.length - 1; index++) {
            boolean flag = false;
            while (aIndex <= arrA.length - 1 && (a < b || bIndex == arrB.length)) {
                arr[index] = a;
                aIndex++;
                if (aIndex <= arrA.length - 1) {
                    a = arrA[aIndex];
                }
                flag = true;
                break;
            }
            if (!flag) {
                while (bIndex <= arrB.length - 1 && (a > b || aIndex == arrA.length)) {
                    arr[index] = b;
                    bIndex++;
                    if (bIndex <= arrB.length - 1) {
                        b = arrB[bIndex];
                    }
                    break;
                }
            }
        }
        return arr;
    }

    private static int[] method2(int[] a, int[] b) {
        int n = a.length - 1;
        int m = b.length - 1;
        int[] result = new int[a.length + b.length];
        while (n >= 0 && m >= 0) {
            int i = a[n];
            int j = b[m];
            if (i > j) {
                result[n + m + 1] = i;
                n--;
            } else {
                result[n + m + 1] = j;
                m--;
            }
        }
        while (n >= 0) {
            result[n] = a[n];
            n--;
        }
        while (m >= 0) {
            result[m] = b[m];
            m--;
        }
        return result;
    }
}
