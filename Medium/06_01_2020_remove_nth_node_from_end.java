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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        // Move second pointer n nodes ahead
        for (int i  = 0; i < n; i++) {
            second = second.next;
        }
        // Edge case if the head of the list is the node to remove
        if (second == null) {
            return head.next;
        }
        // Move both pointers in tandem until the second pointer is pointing to the last element in the list
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        // First.next will now be the node to overwrite
        first.next = first.next.next;
        return head;
    }
}