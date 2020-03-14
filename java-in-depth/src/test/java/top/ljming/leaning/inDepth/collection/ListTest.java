package top.ljming.leaning.inDepth.collection;

import org.junit.Test;

import java.util.*;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ListTest {

    @Test
    public void ArrayListTest1() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }

        for (int idx = 0; idx < nums.size(); idx++) {
            nums.remove(nums.get(idx));
        }
    }

    @Test
    public void ArrayListTest2() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        for (Integer i : nums) {
            nums.remove(i);
        }
    }

    @Test
    public void ArrayListTest3() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        Iterator it = nums.iterator();
        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            nums.remove(i);
        }
    }

    @Test
    public void VectorTest1() {
        List<Integer> nums = new Vector<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
    }

    @Test
    public void LinkedListTest1() {
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        nums.add(0, 1);
        nums.add(1);
        nums.addFirst(1);
        nums.addLast(1);

        nums.get(1);
        nums.getFirst();
        nums.getLast();

    }

    @Test
    public void test2Arr() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "_");
        }
        String[] arr = new String[0];
        arr = list.toArray(arr);

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
