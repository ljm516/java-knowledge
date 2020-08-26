package top.ljming.javaindepth.dsa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class S {

    public List<List<Integer>> func(int target) {
        if (target <= 0) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int sum = queue.peek();

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 2; i < target; i++) {
            queue.offer(i);
            sum += i;
            if (sum == target) {
                List<Integer> tem = new ArrayList<>();
                int idx = 0;
                while (idx < queue.size()) {
                    tem.add(queue.get(idx));
                    idx++;
                }
                result.add(tem);
                sum -= queue.poll();
                continue;
            }
            while (sum > target) {
                sum -= queue.poll();
                if (sum == target) {
                    List<Integer> tem = new ArrayList<>();
                    int idx = 0;
                    while (idx < queue.size()) {
                        tem.add(queue.get(idx));
                        idx++;
                    }
                    result.add(tem);
                    sum -= queue.poll();
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        S s = new S();
        System.out.println(s.func(9));
    }
}
