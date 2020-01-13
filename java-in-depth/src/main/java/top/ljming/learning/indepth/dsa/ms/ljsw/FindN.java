package top.ljming.learning.indepth.dsa.ms.ljsw;

/**
 *  给一个环形数据结构，一个数字n，从第一个数开始计数，数到第n个数，
 *  把这个节点从环形数据结构中去掉，然后从这个节点的下一个开始数，依此类推，取最后剩下的那个.
 *
 * @author lijm
 */
public class FindN {

    public static void main(String[] args) {

    }

    public Object find(CircleArr circleArr, int n) {


        return null;
    }

    public static class CircleArr {
        private int hIndex;
        private int tIndex;
        private int[] arr;
        private int maxSize;

        CircleArr(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
        }


    }

}
