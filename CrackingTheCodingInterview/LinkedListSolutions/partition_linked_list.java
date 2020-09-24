/**
 * Time: O(n)
 * Space: O(n)
 */
public ListNode partition(ListNode node, int x) {
    // Create two lists. One for nodes less than x and the other
    // For nodes greater than x. Iterate through the input list
    // building the lesser and greater list and merge at the end
    ListNode beforeStart = null;
    ListNode afterStart = null;
    ListNode beforeEnd = null;
    ListNode afterEnd = null;
    
    while (node != null) {
        // Let us insert into the before and after lists
        ListNode next = node.next;
        node.next = null; // ??
        if (node.val < x) {
            // Insert into before list
            if (beforeStart == null) {
                beforeStart = node;
                beforeEnd = beforeStart;
            } else {
                beforeEnd.next = node;
                beforeEnd = node;
            }
        } else {
            // Insert into after list
            if (afterStart == null) {
                afterStart = node;
                afterEnd = afterStart;
            } else {
                afterEnd.next = node;
                afterEnd = node;
            }
        }
        node = node.next;
    }
    // Now we check if our before list == null, meaning we only
    // Have nodes that are greater so we return after
    if (beforeStart == null) return afterStart;
    
    // Merge both before and after lists
    beforeEnd.next = afterStart;
    return beforeStart;
}