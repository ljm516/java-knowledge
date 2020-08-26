package top.ljming.javaindepth.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class HashMapInDeep {


    public static void main(String[] args) {
        HashMapInDeep hmid = new HashMapInDeep();
        hmid.mapIndeep();
    }

    public void mapIndeep() {
        Map map = new HashMap(30);
        map.put("1", "a");
    }

    public void tableIndeep() {
        Map map = new Hashtable();
    }

    public void concurrentHashMapIndeep() {
        Map map = new ConcurrentHashMap();
    }
}
