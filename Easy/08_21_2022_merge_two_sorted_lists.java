/**
    LeetCode 21
    Time: O(n)
    Space: O(n)
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;

        ListNode newList = new ListNode(0);
        ListNode newListHead = newList;

        while (head1 != null && head2 != null) {
            int num1 = head1.val;
            int num2 = head2.val;
            if (num1 < num2) {
                newList.next = head1;
                newList = newList.next;
                head1 = head1.next;
            } else {
                // num 1 >= num2
                newList.next = head2;
                newList = newList.next;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            newList.next = head1;
        }
        if (head2 != null) {
            newList.next = head2;
        }
        return newListHead.next;
    }
}