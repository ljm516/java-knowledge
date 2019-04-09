package top.ljming.springmvc.learn.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SpringmvcLearnTestApp {

    public static void main(String[] args) throws ParseException {
//        System.out.println("this is springmvc learn application");
//        getTime();
//        test11();

//        test12();
//        for (int i = 0; i <= 10; i++) {
//            Date r = randomDate("2018-10-23 00:00:00", "2018-10-30 00:00:00");
//            System.out.println("random date: " + r);
//        }
//        randomTest();
        test();
    }


    public static void randomTest() {
        int i;
        Random random = new Random();
        do {
            i = random.nextInt(11);
            System.out.println(i);
        } while (i != 0 && i != 12);

    }


    public static void getTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = sdf.parse("2018-11-17 11:47:00");

        System.out.println("curDate： " + curDate.getTime() / 1000);
        System.out.println("system： " + System.currentTimeMillis() / 1000);

        Long interval = curDate.getTime() / 1000 - System.currentTimeMillis() / 1000 ;

        System.out.println("interval: " + interval);

        Long l = -1L;
        System.out.println(l.intValue());

    }

    public static void test11() {
        for (int i = 0; i <= 10; i++) {
            int max = 4;
            int min = 0;
            Random random = new Random();
            int s = random.nextInt(max) % (max - min + 1) + min;
            System.out.println("s: " + s);
        }
    }

    public static void test12() {
        long startTime = System.currentTimeMillis();
        System.out.println(new Date(startTime + 60000));
    }

    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        return rtn;
    }

    private static void test() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "aaaa");


        System.out.println(map.get("name"));
    }
}
