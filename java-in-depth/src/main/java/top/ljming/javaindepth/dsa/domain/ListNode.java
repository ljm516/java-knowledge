package top.ljming.javaindepth.dsa.domain;

/**
 * 单链表.
 *
 * @author lijm
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}
