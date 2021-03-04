import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        // System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
    public static boolean loopDetection(ListNode head) {
        
        // Make sure head.next != null
        ListNode fast = head;
        ListNode slow = head.next.next;
        
        while (fast != slow) {
            if (slow == null || slow.next == null) return null;
            fast = fast.next;
            slow = slow.next.next;
        }
        // When we break they intersect
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    
}