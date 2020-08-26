package top.ljming.javaindepth.dsa.leetcode;

import top.ljming.javaindepth.dsa.domain.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lijm
 */
public class RotateRightLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        head = rotateRight(head, 2);
        System.out.println(head.val);

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || null == head) {
            return head;
        }
        ListNode tailPre = head;
        ListNode tail;
        ListNode start = head;
        while (k > 0) {
            if (start.next == null) {
                tailPre = start;
            } else {
                while (start.next != null) {
                    tailPre = start;
                    start = start.next;
                }
            }
            tail = tailPre.next;
            if (tail == null) {
                return tailPre;
            }
            tail.next = head;
            tailPre.next = null;
            head = tail;
            start = head;
            k--;
        }
        return head;
    }
}
