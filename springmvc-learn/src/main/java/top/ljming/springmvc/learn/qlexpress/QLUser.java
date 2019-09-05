package top.ljming.springmvc.learn.qlexpress;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

@Data
public class QLUser {
    private int id;
    private String name;
    private int age;


    public static String firstToUpper(String value) {
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        value = StringUtils.trim(value);
        String f = StringUtils.substring(value, 0, 1);
        String s = "";
        if (value.length() > 1) {
            s = StringUtils.substring(value, 1);
        }
        return f.toUpperCase() + s;
    }

    public static String upper(String value) {
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        String  result = value.toUpperCase();
        System.out.println("result:" + result);
        return result;
    }

    public boolean anyContains(String str, String search) {
        char[] s = str.toCharArray();
        for (char c : s) {
            if (search.contains(c + "")) {
                return true;
            }
        }
        return false;
    }
}
