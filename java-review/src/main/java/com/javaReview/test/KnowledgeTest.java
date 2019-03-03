package com.javaReview.test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jiangmingli on 2017/10/12.
 */
public class KnowledgeTest {

    public static void main(String[] args) {
//        test1();
//        test2();
//        testInteger();
//        testConcurrentModificationException();
//        testString();
//        String s = new String("ljm");
//        try {
//            byte[] bytes = s.getBytes("utf-8");
//            System.out.println(bytes);
//        } catch (UnsupportedEncodingException e){
//            e.printStackTrace();
//        }
//        unChangeString();
        breakStringUnChanged();
        classLoaderTest();
    }



    // test1
    public static void test1() {
        Object[] objectArray = new Long[1];
        objectArray[0] = "abc";
        System.out.println(objectArray[0]);
    }

    // 常量池？？？
    public static void test2() {
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);

    }

    // test Integer
    public static void testInteger() {
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println(i01 == i02); //true
        System.out.println(i01 == i03); //true
        System.out.println(i04 == i03); //false
        System.out.println(i04 == i02); //true
    }

    // test ConcurrentModificationException
    public static void testConcurrentModificationException() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("ljm" + i);
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("ljm0")) {
                list.remove(str);
            }
        }
    }

    // "==" & "equals"
    public static void testString() {
        String a = "123";
        String b = "123";
        System.out.println(a == b); // true
        System.out.println(a.equals(b) + "\n"); // true

        String c = new String("1234");
        String d = new String("1234");
        System.out.println(c == d); // false
        System.out.println(c.equals(d) + "\n"); // true

        String e = "a1";
        String f = "a" + 1;
        System.out.println(e == f); // true
        System.out.println(e.equals(f) + "\n"); // true

        String g = "gh";
        String hh = "h";
        String h = "g" + hh; // gh
        System.out.println(g == h); // false
        System.out.println(g.equals(h)); // truecom.javaReview.pattern.factoryPattern.factoryMethod
    }

    // 检验string的不可变性
    public static void unChangeString() {
        String str1 = "ljming";
        str1.replace("l", "L");
        System.out.println(str1);
    }
    // 破坏String的不可变性
    public static void breakStringUnChanged() {
        String str1 = "ljming";
        System.out.println(str1);
        try {
            Field value = String.class.getDeclaredField("value");
            value.setAccessible(true);
            char c[] = (char[]) value.get(str1);
            c[1] = 'm';
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(str1);
    }

    public static void classLoaderTest() {
        try {
            Class clazz = Class.forName("com.javaReview.pattern.factoryPattern.factoryMethod.BenzCar");
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Class benzCar = classLoader.loadClass("com.javaReview.pattern.factoryPattern.factoryMethod.BenzCar");
            System.out.println(clazz.getSimpleName());
            System.out.println(benzCar.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
