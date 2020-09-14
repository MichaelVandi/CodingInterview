/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
    Time: O(A + B)
    Spae: O(1)
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(l1 != null) {
            l1 = l1.next;
            len1++;
        }
        while(l2 != null) {
            l2 = l2.next;
            len2++;
        }
        // Now we have the lenggth the two lists
        if (len1 > len2) {
            // List 1 is longer
            int diff = len1 - len2;
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
            
        } else {
            int diff = len2 - len1;
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

// Hash Set Solution
// Time: O(A + B)
// Spae: O(A)

// import java.util.*;
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Set<ListNode> visited = new HashSet<>();
//         while (headA != null) {
//             visited.add(headA);
//             headA = headA.next;
//         }
//         // Traverse head B to see if we have seen that node
//         while (headB != null) {
//             if (visited.contains(headB)) {
//                 return headB;
//             }
//             headB = headB.next;
//         }
//         return null;
//     }
// }