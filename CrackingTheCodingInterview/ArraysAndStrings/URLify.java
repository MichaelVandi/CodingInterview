import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        String str = "Mr John Smith    ";
      System.out.println(URLify2(str.toCharArray(), 13));
   
    }
    /*
        Approach 1: Using regex
    */
    public static String URLify(String url) {
        return url.replaceAll("[ ]+", "%20");
    }
    /*
        Approach 2: Using true length
    */
    public static String URLify2(char[] url, int trueLength) {
        int spaceCount = 0;
        int index;
        int i = 0;
        for (i = 0; i < trueLength; i++) {
            // Count the number of spaces
            if (url[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        System.out.println("Index : " + index);
        if (trueLength < url.length) {
            url[trueLength] = '\0'; // Mark the end of the array
            System.out.println("yes");
            System.out.println(Arrays.toString(url));
        }
        for (i = trueLength - 1; i >= 0; i--) {
            if (url[i] == ' ') {
                // Replace the 3 consecutive characters backwards with %20
                url[index - 1] = '0';
                url[index - 2] = '2';
                url[index - 3] = '%';
                // Update the new index
                index = index - 3;
                
                System.out.println("New Index: " + index);
                System.out.println(Arrays.toString(url));
            } else {
                // Move the prev character one place up
                url[index - 1] = url[i];
                // Update the index
                System.out.println("New Index: " + index);
                System.out.println(Arrays.toString(url));
                index--;
            }
        }
        return new String(url);
    }
    
    
}