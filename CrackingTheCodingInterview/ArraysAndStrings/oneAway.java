import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      System.out.println(oneAway("bakes", "bale"));
      System.out.println(oneAwayOptimized("bakes", "bale"));
   
    }
   public static boolean oneAway(String a, String b) {
        if (a.length() == b.length()) {
            return isOneReplacementAway(a, b);
        } else if (a.length() - 1 == b.length()) {
            return isOneEditOrDeleteAway(a, b);
        } else if (b.length() - 1 == a.length()) {
            return isOneEditOrDeleteAway(b, a);
        }
        // return false if the two strings have more than one character difference, etc.
        return false;
   }
   public static boolean isOneReplacementAway(String a, String b) {
       // The differ by only one character
       boolean differenceFound = false;
       for (int i = 0; i < a.length(); i++) {
           // check for only one difference
           if (a.charAt(i) != b.charAt(i)) {
               // The first differnce will get a pass
               if (differenceFound) {
                   return false;
               }
               differenceFound = true;
           }
       }
       return true;
   }
   public static boolean isOneEditOrDeleteAway(String a, String b) {
       // Assuming a is the longer string
       int index1 = 0;
       int index2 = 0;
       while (index1 < a.length() && index2 < b.length()) {
           // Compare their characters to make sure they are at least one edit or delete away
           if (a.charAt(index1) != b.charAt(index2)) {
               // They are different, move the longer string one place up
               // if indices 1 and 2 are the same, it means this is the first edit or delete
               // instance that we have come across, so it gets a pass. if indices 1 and 2
               // are different, then we have more than one edit or delete instances
               if (index1 != index2) {
                   return false;
               }
               index1 += 1;
           } else {
               // If they are the same, move on to check the i + 1th characters in both strings
               index1 += 1;
               index2 += 1;
           }
       }
       return true;
   }
   /*
   
        The following is the optimized function that  merges all 3 conditions to one function
   */
   
   
    public static boolean oneAwayOptimized(String a, String b) {
        // Check that the lengths of the strings differ by at most 1
        if (Math.abs(a.length() - b.length()) > 1) return false;
        
        // Determine which string is longer or shorter
        String longer = (a.length() > b.length()) ? a : b;
        String shorter = (a.length() < b.length()) ? a : b;
        
        // Now check for all 3 conditions in one function
        int indexLong = 0;
        int indexShort = 0;
        boolean differenceFound = false;
        
        while (indexLong < longer.length() && indexShort < shorter.length()) {
            if (longer.charAt(indexLong) != shorter.charAt(indexShort)) {
                // Check if we have more than one replace (first condition)
                if (differenceFound) {
                    return false;
                }
                differenceFound = true;
                // Now check for the delete and edit case
                if (longer.length() == shorter.length()) {
                    // Move the shorter pointer forward
                    indexShort += 1;
                    indexLong += 1;
                    // We're always moving the longer pointer at the end of the loop
                } else {
                    // The lengths are different, move the longer one
                    indexLong += 1;
                }
            } else {
                // The characters are the same, move the shorter pointer
                indexShort += 1;
                indexLong += 1;
                
            }
        }
        return true;
        
    }
    
}