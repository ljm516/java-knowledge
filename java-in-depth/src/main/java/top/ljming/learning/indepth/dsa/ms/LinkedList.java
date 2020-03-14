package top.ljming.learning.indepth.dsa.ms;

/**
 * 描述类的功能.【智线】
 * 假设线性表 L = {A1, A2, A3, A4, ..., An-2, An-1, An}，采⽤用带头节点的单链表保存。链接节点定义如
 * 下:
 * typedef struct node { int data;
 * struct node * next;
 * } NODE;
 * 请设计⼀一个算法，编程实现，重新排列列 L 中的各节点，得到线性表 L’ = {A1, An, A2, An-1, A3, An- 2, ... }。
 *
 * @author lijm
 */
public class LinkedList {

    public static void main(String[] args) {
        Node seventh = new Node(7, null);
        Node sixth = new Node(6, seventh);
        Node fifth = new Node(5, sixth);
        Node fourth = new Node(4, fifth);
        Node third = new Node(3, fourth);
        Node second = new Node(2, third);
        Node head = new Node(1, second);
        handle(head);
    }

    public static void handle(Node head) {
        Node start = head;
        // 先算出长度
        int length = 1;
        while (start.next != null) {
            length++;
            start = start.next;
        }
        System.out.println("length:" + length);
        // 再找出中间那个
        int mid = length / 2;
        System.out.println("mod:" + mid);
        Node midNode = head;
        while (mid > 0) {
            midNode = midNode.next;
            mid--;
        }

        Node next;
        while (mid > 0) {
            next = midNode.next;

            mid--;
        }


        System.out.println("data: " + midNode.data);

    }

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
