package top.ljming.learning.indepth.dsa.domain;

/**
 * 自己实现一个链表.
 *
 * @author lijm
 */
public class MyLinkedList {
    public Node head; // 头节点
    public Node tail; // 尾结点
    public int length; // 链表长度

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

    public Object get(int index) {
        if (index > length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.o;
    }


    public void insert(int index, Object o) {
        if (index > length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node old = head;
        for (int i = 0; i < index; i++) {
            old = old.next;
        }
        Node oldNodePre = old.pre;

        if (oldNodePre == null) { // 没有前驱节点，说明old是head
            head = new Node(o, null, old);
            old.pre = head;
        } else {
            /*
            不是头结点，修改原节点的前驱结点为新节点，原节点的前驱节点的后继节点指向新节点。
            新节点的前驱节点指向原节点的前驱结点，后继节点为新节点
             */
            Node newNode = new Node(o, oldNodePre, old);
            old.pre = newNode;
            oldNodePre.next = newNode;
        }
        ++length;
    }

    public Object del(int index) {
        if (index > length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node old = head;
        for (int i = 0; i < index; i++) {
            old = old.next;
        }
        Node oldNext = old.next;
        Node oldPre = old.pre;
        if (old.pre == null) { // 头节点
            head = oldNext;
            oldNext.pre = null;
        } else if (old.next == null) { // 尾结点
            tail = oldPre;
            oldPre.next = null;
        } else {
            oldPre.next = oldNext;
            oldNext.pre = oldPre;
        }
        --length;
        return old.o;
    }

    public class Node {
        public Object o;
        public Node pre;
        public Node next;

        Node(Object o, Node pre, Node next) {
            this.o = o;
            this.pre = pre;
            this.next = next;
        }
    }
}
