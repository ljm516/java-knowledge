package top.ljming.javaindepth.dsa.relearn.lianbiao;

import top.ljming.javaindepth.dsa.domain.ListNode;

/**
 * 判断两个链表是否存在相交的点，返回该相交的节点值.
 * 例: 1->2->3->4>->5->6
 *    1->2->4->5->6
 *    第一个相交的节点是4，返回4.
 *
 * @author ljming
 */
public class LianbiaoApplication {

    public int getMergeNodeValueFromTwoListNode(ListNode l1, ListNode l2) {
        if (null == l1 || null == l2) {
            return -1;
        }

        ListNode first = l1;
        ListNode second = l2;
        while (first != null || second != null) {
            if (second == null) {
                second = l1;
            }
            if (first == null) {
                first = l2;
            }
            if (first.val == second.val) {
                return first.val;
            }
            first = first.next;
            second = second.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        LianbiaoApplication lianbiao = new LianbiaoApplication();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l2 = new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))));
        System.out.println(lianbiao.getMergeNodeValueFromTwoListNode(l1, l2));
    }
}
