package top.ljming.learning.indepth.jvm.momery;

/**
 * 数组直接分配到老年代？.
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author lijm
 */
public class ArrayAllocation {

    public static void main(String[] args) {
        int[] numArray = new int[]{1, 2, 3};

        System.out.println("numArray: " + numArray);
    }
}
