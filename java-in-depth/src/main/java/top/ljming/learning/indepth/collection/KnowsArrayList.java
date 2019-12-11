package top.ljming.learning.indepth.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class KnowsArrayList {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {


        for (int i = 0; i < 15; i++) {
            if (i > 9) {
                list.add("b" + i);
            } else {
                list.add("a" + i);
            }
        }
        list.add(10, "hello");
        System.out.println("before remove: " + list);

        testModCount();

        System.out.println("after remove:" + list);

        testModCount();
    }

    public static void testModCount() {
        int idx = 0;
        for (String s : list) {
            idx ++;

            if (idx == list.size() - 1) {
                list.remove(s);

            }
        }
    }

    public void test1() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }

        for (int idx = 0; idx < nums.size(); idx++) {
            nums.remove(nums.get(idx));
        }
    }

    public void test2() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        for (Integer i : nums) {
            nums.remove(i);
        }
    }

    public void test3() {
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
}
