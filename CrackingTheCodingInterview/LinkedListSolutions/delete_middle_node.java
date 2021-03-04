/**
 * Time: O(1)
 * Space: O(1)
 */
boolean deleteNode(LinkedListNode n) {
    if (n == null || n.next == nUll) {
        return false; // Failure
    }
    LinkedListNode next = n.next;
    n.data = next.data;
    n.next = next.next;
    return true;
 }