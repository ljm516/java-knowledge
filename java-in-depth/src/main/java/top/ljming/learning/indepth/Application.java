package top.ljming.learning.indepth;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * nothing.
 *
 * @author lijm
 */
public class Application {
    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();

        testMap.put("ext_openId", null);
        testMap.put("ext_test", "null");

        System.out.println(JSONObject.toJSONString(testMap));

        System.out.println("learning java in depth");
    }
}
