package top.ljming.learning.indepth.dsa.leetcode;

import top.ljming.learning.indepth.dsa.domain.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。.
 *
 * @author lijm
 */
public class TowNumberAdd {

//    public static void main(String[] args) {
//        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//
//        one.next = two;
//        two.next = three;
//        three.next = four;
//
//        ListNode five = new ListNode(5);
//        ListNode six = new ListNode(6);
//        ListNode seven = new ListNode(7);
//        ListNode eight = new ListNode(8);
//
//        five.next = six;
//        six.next = seven;
//        seven.next = eight;
//
//        ListNode r = solution(one, five);
//        do {
//            System.out.println(r.val);
//        } while ((r = r.next) != null);
//    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;
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

    public static String solution(String s1, String s2) {
        if (null == s1 && s2 == null) {
            return null;
        }
        if (null == s1) {
            return s2;
        }
        if (null == s2) {
            return s1;
        }

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();

        int lens1 = chs1.length;
        int lens2 = chs2.length;
        String result = "";
        while (lens1 > 0 && lens2 > 0) {
            String s1Last = String.valueOf(chs1[lens1 - 1]);
            String s2Last = String.valueOf(chs2[lens2 - 1]);

            int s1v = Integer.parseInt(s1Last);
            int s2v = Integer.parseInt(s2Last);

            if (s1v < s2v) {

                result += s1v + 10 - s2v;
                String gaowei = String.valueOf(chs1[lens1 - 2]);
                int gw = Integer.parseInt(gaowei) - 1;
                chs1[lens1 - 2] = (char) gw;
            } else {
                result += s1v - s2v;
            }
            lens1--;
            lens2--;
        }

        while (lens1 > 0 && chs1[0] != '0') {
            result += chs1[lens1 - 1];
            lens1--;
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "111";
        String s2 = "12";
        System.out.println(solution(s1, s2));
    }
}
