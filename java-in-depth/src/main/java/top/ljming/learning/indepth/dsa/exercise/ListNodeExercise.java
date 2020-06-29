package top.ljming.learning.indepth.dsa.exercise;

import top.ljming.learning.indepth.dsa.domain.ListNode;

/**
 * 链表的练习.
 *
 * @author lijm
 */
public class ListNodeExercise {

    ListNode head;
    ListNode tail;
    int length;

    /**
     * 单链表的反转.
     *
     * @param head 原链表
     * @return 反转后的新链表
     */
    public ListNode reverse(ListNode head) {
        ListNode r = null;
        ListNode dummy;

        while (head != null) {
            dummy = head;
            head = head.next;

            dummy.next = r;
            r = dummy;
        }
        return r;
    }

    public ListNode reverse2(ListNode head) {
        ListNode prev = null;
        ListNode next;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * 检测链表是否有环.
     *
     * @param head 链表
     * @return boolean
     */
    public boolean checkCircle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并两个有序链表.
     *
     * @param l1 有序链表1
     * @param l2 有序链表3
     * @return 合并后的新链表
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0, null);

        ListNode node = r;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        node.next = l1 == null ? l2 : l1;

        return r;
    }

    /**
     * 移除链表中倒数第k个节点.
     *
     * @param head 链表.
     * @param k    k
     * @return 移除倒数第k个节点后的新链表
     */
    public ListNode removeLastKth(ListNode head, int k) {
        ListNode r = new ListNode(0, head);

        ListNode first = r;
        ListNode second = r;
        for (int i = 0; i <= k + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return r.next;
    }

    /**
     * 获取链表的中间节点.
     *
     * @param head
     * @return
     */
    public int getMidNode(ListNode head) {
        ListNode start = head;
        int l = 0;
        while (start != null) {
            start = start.next;
            l++;
        }

        int mid = l / 2;

        while (mid > 0) {
            head = head.next;
            mid--;
        }

        return head.val;
    }

    public ListNode getMidNode2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 单链表的新增
    public void add(ListNode item) {
        if (head == null) {
            head = item;
        } else {
            tail.next = item;
        }
        tail = item;
        length++;
    }

    public ListNode get(int idx) {
        if (idx >= length || idx < 0) {
            throw new ArrayIndexOutOfBoundsException(-1);
        }
        ListNode start = head;
        while (idx > 0 && start != null) {
            start = start.next;
            idx--;
        }
        return start;
    }

    public int remove(int idx) {
        if (idx >= length || idx < 0) {
            throw new ArrayIndexOutOfBoundsException(-1);
        }
        ListNode pre; // 表示要移除节点的前驱节点
        ListNode node; // 要移除的节点
        if (idx == 0) {
            pre = null;
        } else {
            pre = get(idx - 1);
        }
        if (null == pre) { // 如果前驱节点为null，表示删除的节点为头结点
            node = head;
            head = node.next;
        } else {
            node = pre.next;
            if (node.next == null) { // 这就表示要移除的节点是尾结点
                pre.next = null;
                tail = pre;
            } else {
                pre.next = node.next;
            }
        }
        length--;
        return node.val;
    }

    public static void main(String[] args) {
        ListNodeExercise exercise = new ListNodeExercise();

        exercise.add(new ListNode(0));

        ListNode one = new ListNode(1);
        exercise.add(one);
        exercise.add(new ListNode(2));
        exercise.add(new ListNode(3));
        exercise.add(new ListNode(4));
        exercise.add(new ListNode(4));

//        exercise.tail.next = one;

        boolean r = exercise.checkCircle(exercise.head);

        System.out.println(r);

    }
}
