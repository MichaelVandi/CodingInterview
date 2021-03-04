import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        // System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
    public static ListNode sumList(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;
        ListNode result = new ListNode();
        // Now we can add
        int value = 0;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        // Now we can add carry 
        value += carry;
        // determine what carry will be
        result.data = value & 10;
        // Recurse on the next addition if one of l1 or l2 is not null
        if (l1 != null || l2 != null) {
            ListNode next = sumList(l1 == null ? null : l1,
                                    l2 == null ? null : l2,
                                    value / 10);
            result.next = next;
        }
        return result;
        
    }
    
}