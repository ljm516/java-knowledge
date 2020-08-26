package top.ljming.leaning.indepth.collection;

import org.junit.Test;
import top.ljming.javaindepth.collection.ListClassInDeep;

import java.util.*;

/**
 * List集合类测试.
 *
 * @author lijm
 */
public class ListTest {

    private ListClassInDeep listClassInDeep = new ListClassInDeep();

    @Test
    public void testModification() {
        List<Integer> arrList = new ArrayList<>();
        listClassInDeep.arrayListConcurrentModifyException(arrList);
    }

    @Test
    public void testUnSoftRemove() {
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i< 10; i++) {
            arrList.add(i);
        }
        listClassInDeep.arrayListUnSafeRemove(arrList);
    }

    @Test
    public void testSafeRemove() {
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i< 10; i++) {
            arrList.add(i);
        }
        listClassInDeep.arrayListSafeRemove(arrList);
    }
}
