/**
 * 描述类的功能.
 *
 * @author ljming
 */
package top.ljming.learning.indepth.dsa.ms;

import java.util.*;

/**
 * 新东方笔试题.
 *
 * @author ljming
 */
public class XDF {

    /*
    有N个鸡蛋，要依次投放到如下盒子中（盒子数未知，直至全部放入为止），
    【1】，【2】，【4】，【8】，【16】。。。。【？】
    请问，已知n个鸡蛋，最后一个盒子有多少个鸡蛋？
     */
    public int egg(int eggs) {
        int n = 0;
        double curr;
        while (eggs >= (curr = Math.pow(2, n))) {
            System.out.println(curr);
            eggs -= curr;
            n++;
        }

        return eggs;
    }

    public static void main(String[] args) {
        XDF xdf = new XDF();
        System.out.println(xdf.egg(256));
    }

    /*
    school,lesson类如下
    学校数据
    Class school{
    int shoolid;
    String schoolname; //学校名字
    };
    //上课数据
    Class lesson{
    int schoolid;
    int studentCount; //学生数量
    }
    分别有2个list：List<school> schools;List<lesson> lessons，存放school与lesson数据，lessions含有多条相同schoolid的数据，
    现在需要统计每个学校上课的学生总数，并且将学校数据按照上课学生总数降序排列，将上课学生总数>1000的学校名字存放到一个list中。
     */
    static class School {
        int schoolId;
        String schoolName;
    }

    static class Lesson {
        int schoolId;
        int studentCount;
    }

    class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override

        public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
            return entry2.getValue() - entry1.getValue();
        }

    }

    public List<School> function(List<School> schools, List<Lesson> lessons) {

        SortedMap<Integer, Integer> studentCountMap = new TreeMap<Integer, Integer>((Map<? extends Integer, ? extends Integer>) new MyComparator());

        for (Lesson lesson : lessons) {
            if (studentCountMap.containsKey(lesson.schoolId)) {
                studentCountMap.put(lesson.schoolId, studentCountMap.get(lesson.schoolId) + lesson.studentCount);
            } else {
                studentCountMap.put(lesson.schoolId, lesson.studentCount);
            }
        }

        List<School> result = new ArrayList<>();
        for (School school : schools) {
            if (studentCountMap.get(school.schoolId) > 1000) {
                result.add(school);
            }
        }
        return result;
    }
}
