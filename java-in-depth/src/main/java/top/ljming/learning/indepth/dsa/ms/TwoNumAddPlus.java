package top.ljming.learning.indepth.dsa.ms;

/**
 * 小米.
 * <p>
 * <p>
 * 给定两个链表
 * 1->2->3->4
 * 5->6->7->8
 * 代表两个数，1234 和 5678
 * 求和
 * 返回一个新的链表
 * 6912 6->9->1->2
 * <p>
 * class ListNode {
 * int value;
 * ListNode next;
 * }
 * <p>
 * public ListNode fun(ListNode a, ListNode b) {
 * }
 *
 * @author lijm
 */
public class TwoNumAddPlus {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);

        five.next = six;
        six.next = seven;
        seven.next = eight;

        ListNode r = func(one, five);
        r = evertListNode(r);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    private static ListNode func(ListNode n1, ListNode n2) {
        n1 = evertListNode(n1);
        n2 = evertListNode(n2);
        ListNode head = new ListNode(0);
        ListNode p = n1, q = n2, curr = head;
        int carry = 0; // 进位
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;

    }

    // 单向链表的翻转
    private static ListNode evertListNode(ListNode l) {
        ListNode r = null;
        ListNode node;

        ListNode start = l;
        while (start != null) {
            node = start;
            start = start.next;

            node.next = r;
            r = node;
        }

        return r;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
