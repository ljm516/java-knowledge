package top.ljming.learning.indepth.collection;

/**
 * 自己实现一个链表.
 *
 * @author lijm
 */
public class MyLinkedList {
    Node head; // 头节点
    Node tail; // 尾结点
    int length; // 链表长度

    public void add(Object o) {
        Node last = tail;
        Node newNode = new Node(o, last, null);
        tail = newNode;
        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        ++length;
    }

    public void add(int index, Object o) {
        if (index > length - 1|| index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node old = head;
        for (int i= 0; i < index; i++) {
            old = old.next;
        }
        Node newNode = new Node(o, old.pre, old);
    }


    class Node {
        Object o;
        Node pre;
        Node next;

        Node(Object o, Node pre, Node next) {
            this.o = o;
            this.pre = pre;
            this.next = next;
        }
    }
}
