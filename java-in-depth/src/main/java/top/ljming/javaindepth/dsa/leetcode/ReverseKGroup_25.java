package top.ljming.javaindepth.dsa.leetcode;

import top.ljming.javaindepth.dsa.domain.ListNode;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ReverseKGroup_25 {

    public static void main(String[] args) {
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ReverseKGroup_25 solution = new ReverseKGroup_25();
        ListNode r = solution.func(one, 2);
        System.out.println(r.val);
    }

    public ListNode func(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 将end指针指向要翻转的那个节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 起始节点
            ListNode start = pre.next;
            // 下一次开始翻转的节点
            ListNode next = end.next;

            // 将要翻转的那个节点和它的下一个节点断开
            end.next = null;
            // 进行翻转
            pre.next = reverse(start);
            // 翻转后，起始几点成了尾结点，和下一次要开始翻转的节点相连
            start.next = next;

            pre = start;

            end = pre;
        }

        return dummy.next;
    }

    private ListNode reverse (ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
