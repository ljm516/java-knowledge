package top.ljming.javaindepth.dsa.ms;

import top.ljming.javaindepth.dsa.domain.ListNode;

/**
 * 删除这个链表倒数第K个元素，并返回链表头结点.
 *
 * @author lijm
 */
public class RemoveK {

    public ListNode deleteK(ListNode head, int k) {
        ListNode r = new ListNode(0, head);

        ListNode first = r;
        ListNode second = r;
        for (int i = 1; i <= k + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return r.next;
    }

    public static void main(String[] args) {
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        RemoveK removeK = new RemoveK();
        ListNode r = removeK.deleteK(one, 2);
        System.out.println(r.val);
    }
}
