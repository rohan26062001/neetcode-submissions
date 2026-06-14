/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1), curr = node;
        int carry = 0;

        while(l1 != null || l2 != null || carry > 0) {
            int total = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            curr.next = new ListNode(total%10);
            curr = curr.next;
            carry = total / 10;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return node.next;
    }
}
