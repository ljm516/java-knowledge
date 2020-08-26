package top.ljming.javaindepth.dsa.ms;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 有趣的两位数. 智线
 *
 * 有数学家发现⼀些两位数很有意思，⽐如，
 * 34 * 86 = 43 * 68
 * 也就是说，如果把他们的⼗位数和个位数交换，二者乘积不不变。 编程求出满足该性质的两位数组合。
 * @author lijm
 */
public class FunnyNumbers {
    public static void main(String[] args) {
        Map<Integer, Integer> nums = new HashMap<>();
        int preShiwei;
        int preGewei;
        int nextShiwei;
        int nextGewei;
        for (int num = 10; num < 100; num++) {
            for (int n = num + 1; n < 100; n++) {
                preShiwei = num / 10;
                preGewei = num % 10;
                nextShiwei = n /10;
                nextGewei = n % 10;

                if (preShiwei * nextShiwei == preGewei * nextGewei) {
                    nums.put(num, n);
                }
            }
        }
        System.out.println(JSONObject.toJSONString(nums));
    }
}
