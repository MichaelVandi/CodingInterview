// This is almost identical to the remove kth node from end question (in the Medium folder)
/**
 * Time: O(n)
 * Space: O(1)
 */
public ListNode nthToLast(ListNode head, int k) {
    ListNode p1 = head;
    ListNode p2 = head;
    // Move p1 k nodes ahead
    for (int i = 0; i < k; i++) {
        if (p1 == null) return null; // Out of bounds
        p1 = p1.next;
    }
    // Move both pointers in tandem until p1 reaches the end
    while (p1 != null) {
        p1 = p1.next;
        p2 = p2.next;
    }
    return p2;
}