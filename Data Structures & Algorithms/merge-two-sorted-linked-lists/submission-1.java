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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), curr = dummy, p1 = list1, p2 = list2;

        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                curr.next = new ListNode(p1.val);
                curr = curr.next;
                p1 = p1.next;
            } else if(p1.val > p2.val) {
                curr.next = new ListNode(p2.val);
                curr = curr.next;
                p2 = p2.next;
            } else {
                curr.next = new ListNode(p1.val);
                curr = curr.next;
                p1 = p1.next;
                curr.next = new ListNode(p2.val);
                curr = curr.next;
                p2 = p2.next;
            }
        }

        while(p1 != null) {
            curr.next = new ListNode(p1.val);
            curr = curr.next;
            p1 = p1.next;
        }

        while(p2 != null) {
            curr.next = new ListNode(p2.val);
            curr = curr.next;
            p2 = p2.next;
        }

        return dummy.next;
    }
}