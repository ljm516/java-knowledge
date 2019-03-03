package com.javaReview.LinkedList;

import com.javaReview.domain.employee.Employee;

import java.util.*;

/**
 * Created by jiangmingli on 2017/10/10.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        List<String> b = new LinkedList<>();
        Map<String, Employee> employeeMap = new HashMap<>();
        for(int i = 0; i < 5; i++){
            a.add("a" + i);
            b.add("b" + i);
        }

        ListIterator aIter = a.listIterator();
        Iterator bIter = b.iterator();

        while (bIter.hasNext()){
            if (aIter.hasNext()){
                // 在队列的前面加
                aIter.add(bIter.next());
            }
        }

        System.out.println(a);

        // remove every second element from b
        bIter = b.iterator();
        while (bIter.hasNext()){
            String temp = (String)bIter.next(); //skip next element
            System.out.println(temp);
            if (bIter.hasNext()){
                String temp2 = (String)bIter.next(); //skip next element
                System.out.println(temp2);
                bIter.remove(); //remove that element
            }
        }

        System.out.println(b);

        a.removeAll(b); // remove all element in b from a

        System.out.println(a);

    }

    public static int bs(int[] arr, int k){
        int low = 0, high = arr.length - 1;
        int mid = low + high / 2;
        while (low <= high) {
            int midValue = arr[mid];
            if (midValue > k){
                high = mid - 1;
            }
            else if (midValue < k) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
