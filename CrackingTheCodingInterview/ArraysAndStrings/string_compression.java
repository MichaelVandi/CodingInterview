import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      System.out.println(compress("aabcccccaaa"));
   
    }
    public static String compress(String s) {
        // TODO: Check for edge cases
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // System.out.println("Current : " + s.charAt(i));
            count += 1;
            // We get the current character
            char thisChar = s.charAt(i);
            //  System.out.println(i + " : " + thisChar + " : " + count);
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                // reset
                // System.out.println("should append " + i + " : " + s.charAt(i) + " : " + count);
                sb.append(s.charAt(i));
                sb.append(count);
                count = 0;

            } 

        }
        
        
        return sb.toString().length() < s.length() ? sb.toString() : s;
    }
    
}public class string_compression {
    
}
