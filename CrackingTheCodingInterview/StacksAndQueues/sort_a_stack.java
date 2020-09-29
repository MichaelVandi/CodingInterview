/**
 * Time: O(n^2)
 * Space: O(n)
 */
import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        // Create an example stack and add items to it
        Stack<Integer> s = new Stack<>();
        int[] numbers = new int[]{5, 7, 3, 6, 7, 3, 27, 4};
        for (int num : numbers) {
            s.push(num);
        }
        // Call the sorting function we created below
        sort(s);
        while (!s.isEmpty()) {
            // Print to see that the sorting actually worked
            System.out.print(s.pop() + ",");
        }
        
    }
    
    /*
            The idea is to create an additional stack
            which will be sorted and we maintain it's state by
            popping larger elements out and pushing smaller elements in
            
    */
    public static void sort(Stack<Integer> main) {
        Stack<Integer> temp = new Stack<>();
        // While there are elements in main
        while (!main.isEmpty()) {
            // Pick a pivot value
            int pivot = main.pop();
            // While we have bigger values in temp, pop em out
            while (!temp.isEmpty() && temp.peek() > pivot) {
                main.push(temp.pop());
            }
            // otherwise, push pivot in
            temp.push(pivot);
            
        }
        // Add the elements back into main so that they appear in
        // Ascending order
        while (!temp.isEmpty()) {
            main.push(temp.pop());
        }
    }

}
