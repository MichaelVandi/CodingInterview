class Solution {
    public boolean isPalindrome(ListNode head) {
        // Move two pointers together.
        // Ptr one moves one step and Ptr 2 moves two steps. When ptr2 is null, ptr1
        // will be in the middle of the list
        // reset ptr2 to head, and reverse list starting at ptr1 (middle)
        // Move both pointers in tandem and check for equality
        
        ListNode fast = head;
        // Reverse the second list
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        slow = reverse(slow);
        // Now check them in tandem for equality
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}