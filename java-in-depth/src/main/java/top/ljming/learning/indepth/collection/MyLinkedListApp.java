package top.ljming.learning.indepth.collection;

import top.ljming.learning.indepth.dsa.self.MyLinkedList;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class MyLinkedListApp {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("hello");
        myLinkedList.add("world");

        myLinkedList.insert(0, "myLinkedList");

        System.out.println("-----------before del----------");
        for (int i = 0; i < myLinkedList.length; i++) {
            System.out.println(myLinkedList.get(i));
        }

        myLinkedList.del(1);
        System.out.println("-----------after del-----------");
        for (int i = 0; i < myLinkedList.length; i++) {
            System.out.println(myLinkedList.get(i));
        }

    }
}
