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
    public void reorderList(ListNode head) {
        // 1. Find the Middle
        ListNode dummy = new ListNode(-1, head), slow = dummy, fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode reversed = reverse(slow.next);
        slow.next = null;

        // 3. Alternate
        ListNode temp1 = head, temp2 = reversed;
        while(temp2 != null) {
            ListNode headNext = temp1.next;
            ListNode midNext = temp2.next;
            temp1.next = temp2;
            temp2.next = headNext;
            temp2 = midNext;
            temp1 = headNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, temp = head;
        while(temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
}
