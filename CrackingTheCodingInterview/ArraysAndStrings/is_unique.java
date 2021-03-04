public class MyClass {
    public static void main(String args[]) {
      System.out.println(hasUniqueCharsOptimized("abc"));
    }
    /*
        Time: O(n) -> check if the "contains" method in a string runs in O(n) time,
        in that case it will be O(n^2)
        Space: O(1)
    */
    public static boolean hasUniqueChars(String s) {
        // Approach: Go through s, at every index.
        // Check the left and right sides to see if the same char is present
        // We may only need to check the left side even
        if (s.length() == 0 || s == null) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            String leftSide = s.substring(0, i);
            if (leftSide.contains(current)) {
                // We've seen this before, return false
                return false;
            }
        }
        // If we did not see a repeating character
        return true;
    }
    
    // Alternatively, each character has a unique asc code. We can create an array of all possible
    // asc codes and enter true or false when we see a character
    public static boolean hasUniqueCharsOptimized(String s) {
        boolean[] contains = new boolean[128]; // Assuming alpha numeric only
        // You can also do 26 and convert the letter to it's alphabetical number
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i);
            if (contains[value]) {
                return false;
            }
            // Else, put this value in the contains array
            contains[value] = true;
        }
        // If we did not see a repeating character
        return true;
    }
    
}