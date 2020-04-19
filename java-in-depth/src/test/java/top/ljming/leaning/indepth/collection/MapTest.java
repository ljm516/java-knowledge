package top.ljming.leaning.indepth.collection;

import org.junit.Test;

import java.util.*;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class MapTest {

    Map<Integer, String> hashMap = new HashMap<>();

    Map<Integer, String> table = new Hashtable<>();

    Map<Integer, String> treeMap = new TreeMap<>();

    Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

    @Test
    public void hashMapTest() {
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, String.valueOf(i));
        }

//        hashMap.put(1, "a");


        hashMap.put(5, "5q");

        hashMap.get(5);

    }

    @Test
    public void test() {
        System.out.println(-10 ^ -10 >>> 16);
    }
}
