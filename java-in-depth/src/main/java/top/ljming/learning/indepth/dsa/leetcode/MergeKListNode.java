package top.ljming.learning.indepth.dsa.leetcode;

import top.ljming.learning.indepth.dsa.domain.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并k个有序列表.
 *
 * @author lijm
 */
public class MergeKListNode {

    public ListNode merge(ListNode[] lists) {
        ListNode fakeNode = new ListNode(-1);
        ListNode p = fakeNode;

        PriorityQueue<ListNode> litterHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode n : lists) {
            if (n != null) {
                litterHeap.offer(n);
            }
        }

        while (!litterHeap.isEmpty()) {
            ListNode node = litterHeap.poll();
            p.next = node;
            p = p.next;

            if (node.next != null) {
                litterHeap.offer(node.next);
            }
        }

        return fakeNode.next;
    }

}
