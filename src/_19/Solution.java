package _19;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        List<ListNode> nl = new ArrayList<>();
        nl.add(head);
        while (tmp.next != null) {
            tmp = tmp.next;
            nl.add(tmp);
        }
        int idx = nl.size() - n - 1;
        if (idx < 0) {
            return null;
        } else if (idx == 0) {
            return head.next;
        } else {
            tmp = nl.get(idx);
            tmp.next = tmp.next.next;
            return head;
        }
    }
}
