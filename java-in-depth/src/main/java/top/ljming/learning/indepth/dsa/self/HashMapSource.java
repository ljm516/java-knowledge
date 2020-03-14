package top.ljming.learning.indepth.dsa.self;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap.
 *
 * @author lijm
 */
public class HashMapSource {

    public static void main(String[] args) {
        Map<String, String> sourceMap = new HashMap<>();

        Hashtable hashtable = new Hashtable();

        hashtable.put(null, null);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        sourceMap.put("123", "123");
        sourceMap.put("123", "123");

        ConcurrentHashMap hashMap = new ConcurrentHashMap();

    }
}
