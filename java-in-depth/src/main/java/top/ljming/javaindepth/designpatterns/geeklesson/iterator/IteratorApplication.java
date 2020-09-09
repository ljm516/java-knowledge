package top.ljming.javaindepth.designpatterns.geeklesson.iterator;

import com.sun.jdi.connect.spi.TransportService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class IteratorApplication {

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//        Iterator it1 = list.iterator();
//        Iterator it2 = list.iterator();
//
//        it1.next();
//        it1.remove();
//        System.out.println(it2.next());
        linkedList();
    }

    public static void linkedList() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator it = list.iterator();
        it.next();

        list.add(10);

    }
}
