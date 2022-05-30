/**These are mostly my own solutions, sometimes I put the solutions in the book too, but you get the idea */
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      System.out.println(checkPermutation2("abc", "bac"));
    }
    /*
        Sorting approach 
        Time: O(n log n)
    */
    public static boolean checkPermutation(String a, String b) {
        // if one is a permutation of the other, they have the same characters
        // you can sort them and check for equality
        // you can count the occurence of each character
        String nA = sort(a);
        String nB = sort(b);
        return nA.equals(nB);
        
    }
    /*
        Count each occurence approach O(n)
    */
    public static boolean checkPermutation2(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char current = a.charAt(i);
            // Increment this character's occurences or put 1 if it's the first occurence
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        // Now go through b and make sure it's the same or subtract one
        for (int i = 0; i < b.length(); i++) {
            char current = b.charAt(i);
            if (!map.containsKey(current)) {
                return false;
            }
            // if it's there subtract it
            map.put(current, map.get(current) - 1);
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) != 0) {
                // Something went wrong return false
                return false;
            }
        }
        return true;
    }
    public static String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    // Did not compile the following method but should be conceptually
    // understandable
    public static boolean isPermutation2(String a, String b) {
        // Count the characters at each ascii index
        boolean[] ascii = new boolean[128];
        for (char ca : a.toCharArray()) {
            int asciiVal = (int) ca;
            ascii[asciiVal]++;
        }
        // Now iterate through ascii with b and subtract
        for (char cb : b.toCharArray()) {
            int asciiVal = (int) cb;
            ascii[asciiVal]--;
            if (ascii[asciiVal] < 0) return false;
        }
        return true;
    }
    
}

