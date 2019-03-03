package com.javaReview.domain.employee;

import java.util.*;

/**
 * Created by jiangmingli on 2017/10/10.
 */
public class EmployeeBO {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Queue<Employee> queue = new LinkedList<>();

        employees.add(new Employee("ljm"));
//        List<Employee> linkedList = new LinkedList<>();
//
//
//        Iterator it = employees.iterator();
//        Employee e = (Employee) it.next();
//        boolean b = employees.add(e);
//        System.out.println(b);
        Employee e1 = new Employee.Builder().setName("ljm").build();
        System.out.println(e1.getName());

        Employee e2 = new Employee("ljm");
        Employee e3 = new Employee("ljm");
        System.out.println(e2.hashCode() + " " + e3.hashCode() + "\n");
        System.out.println(e2.equals(e3));
    }

    public static String replaceSpace(StringBuffer str) {
        String string = str.toString();
        return string;
    }
}
