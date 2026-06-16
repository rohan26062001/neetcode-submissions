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
        ListNode dummy = new ListNode(0), curr = dummy;
        int c = 0;

        while(l1 != null || l2 != null || c != 0) {
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            
            int add = first + second + c;
            c = add / 10;
            add = add % 10;
            curr.next = new ListNode(add);
            curr = curr.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummy.next;
    }
}
