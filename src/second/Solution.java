package second;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val;
        int mark = 0;
        ListNode headNode = new ListNode(0);
        ListNode node = headNode;
        while (l1 != null || l2 != null) {
            val = mark;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            mark = val / 10;
            val = val % 10;
            node.val = val;
            if (l1 == null && l2 == null && mark == 0) {
                return headNode;
            }
            node.next = new ListNode(0);
            node = node.next;
        }
        node.val = 1;
        return headNode;
    }
}
