package top.ljming.leaning.indepth;

import org.junit.Test;
import top.ljming.learning.indepth.dsa.sort.QuickSort;

import java.util.Calendar;
import java.util.Date;

/**
 * 排序算法.
 *
 * @author lijm
 */
public class SortTest {

    int[] arr = new int[]{5, 1, 3, 6, 4, 2, 7, 9, 8};

    @Test
    public void quickSort() {
        QuickSort qs = new QuickSort();
        arr = qs.sort(arr);
        for (int i: arr) {
            System.out.print(i+ "，");
        }
    }

    @Test
    public void test() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(w);
    }
}
