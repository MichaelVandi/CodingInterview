
public class MyClass {
    public static void main(String args[]) {
        
    }
    public static boolean isRotation(String s1, String s2) {
           
    }
    public void deleteDups(ListNode n) {
        HashSet<Integer> set = new HashSet<>();
        ListNode prev = null;
        while (n != null) {
            if (set.contains(n.val) {
                prev.next = n.next;
            } else {
                set.add(n.val);
                previous = n;
            }
            n = n.next;
        }
    }
    public void deleteDups(ListNode n) {
        ListNode current = n;
        while (current != null) {
            // Remove all future nodes that have the same value
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        
    }
}
