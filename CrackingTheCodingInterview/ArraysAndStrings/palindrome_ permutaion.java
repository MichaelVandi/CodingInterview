import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        String str = "Mr John Smith    ";
      System.out.println(isPermutationOfPalindrome("Tact Coa"));
   
    }
   public static boolean isPermutationOfPalindrome(String s) {
       s = s.toLowerCase();
       Map<Character, Integer> map = new HashMap<>();
       for (int i = 0; i < s.length(); i++) {
           char current = s.charAt(i);
           // update it's occurence in the map
           if (current == ' ') {
               continue;
           }
           map.put(current, map.getOrDefault(current, 0) + 1);
           
       }
       // Check that no character has more than 1 odd occurence
       boolean foundOdd = false;
       for (char c : map.keySet()) {
           System.out.println(c + " -> " + map.get(c));
           if (map.get(c) % 2 == 1) {
               // it has an odd occurence
               // If we've foundOdd before we return false;
               if (foundOdd) {
                   return false;
               }
               // otherwise we havent found odd before, set to true
               foundOdd = true;
           }
       }
       return true;
   }
    
    
}