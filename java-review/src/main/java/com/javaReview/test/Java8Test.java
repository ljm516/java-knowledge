package com.javaReview.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jiangmingli on 2017/10/17.
 */


public class Java8Test {

    public static void main(String[] args) {
//        System.out.println(collect());
//        System.out.println(map());
//        System.out.println(filter());
//        maxMin();
//        statistics();
//        optional();
//        Map<Boolean, List<String>> map = dataBlock();
//        Map<Boolean, List<Integer>> map = dataGroupBy();
//        for (Map.Entry e: map.entrySet()) {
//            System.out.println(e.getKey());
//            System.out.println(map.get(e.getKey()).toString());
//        }
//        System.out.println(formatString());
        byte2String();

    }



    /**
     * 第三章   常用流操作
     */
    // collect(toList())
    public static long collect() {
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        collected.stream().filter(s -> {
            System.out.println(s);
            return s.equals("a");
        });

        return collected.stream().filter(s -> {
            System.out.println(s);
            return s.equals("a");
        }).count();
    }

    // map
    public static String map() {
        List<String> collected = Stream.of("a", "b", "hello").map(s -> s.toUpperCase()).collect(Collectors.toList());
        return collected.toString();
    }

    // filter
    public static String filter() {
        List<String> collected = Stream.of("1a", "b", "hello")
                .filter(s -> Character.isDigit(s.charAt(0))).collect(Collectors.toList());
        return collected.toString();
    }

    // flatMap
    public static String flatMap() {
        return Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream()).collect(Collectors.toList()).toString();
    }

    // max, min
    public static void maxMin() {
        int max = Stream.of(1, 2, 3, 4).max(Comparator.comparing(number -> number)).get();
        int min = Stream.of(1, 2, 3, 4).min(Comparator.comparing(number -> number)).get();
        System.out.println(max + " " + min);
    }
    /*第三章end*/

    /**
     * 第四章  类库
     */

    //基本类型
    public static void statistics() {
        IntSummaryStatistics iss = Stream.of(1, 2, 3, 4).mapToInt(number -> number).summaryStatistics();
        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                iss.getMax(), iss.getMin(), iss.getAverage(), iss.getSum());
    }

    // optional
    public static void optional() {
        Optional<String> a = Optional.of("a");
        Optional<String> emptyOptional = Optional.empty();

        Optional nullOptional = Optional.ofNullable(null); // 将一个空值转换成optional对象，没有值
        boolean hasValue = emptyOptional.isPresent(); // 检查Optional对象时候有值
        String value = emptyOptional.orElse("b"); // 当Optional为空时，该方法提供了一个备选值
//        emptyOptional.orElseGet(() -> "c");

        System.out.println(a.get());  // out a
        System.out.println(nullOptional.toString());
        System.out.println(hasValue);  // false
        System.out.println(value);  // b
    }

    /**
     * 第五章
     * 高级集合类和收集器
     */

    // 数据分块
    public static Map<Boolean, List<String>> dataBlock() {
        return Stream.of("1a", "2b", "c", "d").collect(Collectors.partitioningBy(s -> Character.isDigit(s.charAt(0))));
    }
    // 数据分组
    public static Map<Boolean, List<Integer>> dataGroupBy() {
        return Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.groupingBy(i -> isBiggerThan3(i)));
    }

    public static boolean isBiggerThan3(int i) {
        return i > 3 ? true : false;
    }

    // 字符串， 使用流和收集器格式化字符串
    public static String formatString() {
        return Stream.of("li", "jiang", "ming").map(s -> s).collect(Collectors.joining(", ", "[", "]"));
    }

    public static void byte2String() {
        byte b = 1;
        Integer i = new Integer(b);
        String s = new String(i.toString());
        System.out.println(s);
    }
}
