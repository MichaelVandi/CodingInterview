
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]) {
        
    //   int[] order = new int[] {2, 7, 4};
    //   int max = 3;
    //   List<Integer> findOrder = orderCalculator(order, max);
    //   for (int num: findOrder) {
    //       System.out.println(num);
    //   }
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    // int t = 1;
    for (int i = 1; i <= t; ++i) {
        // Reading the test cases
      int n = in.nextInt(); // Number of people standing in the queue
      int m = in.nextInt(); // Max amount
      int[] order = new int[n];
      for (int j = 0; j < n; j++) {
          // add next int to array
          order[j] = in.nextInt();
          // System.out.println("Order at " + j + " " + order[j]);
      }
      List<Integer> result = orderCalculator(order, m);
      StringBuilder answer = new StringBuilder();
      answer.append("Case #" + i + ": ");
      
      result.forEach(nb -> answer.append(nb + " "));
      System.out.println(answer.toString());
    }
    }
    public static List<Integer> orderCalculator(int[] order, int x) {
        // Create an actual queue;
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= order.length; i++) {
            // Add i to the queue
            queue.offer(i);
        }
        // Now that we have built the queue, we can process getting peeps out
        while (!queue.isEmpty()) {
            // While we still have people in the queue
            int index = queue.poll();
            int amount = order[index - 1];
            // Let us process this person
            
            if (amount <= x) {
                // this person is cleared to go
                result.add(index);
                
            } else {
                // The amount is greater
                order[index - 1] = amount - x;
                // Add this person back to the queue
                queue.offer(index);
            }
        }
        return result;
        
    }
}


// import java.util.*;
// import java.io.*;
// public class Solution {
//   public static void main(String[] args) {

//   }
// }
  
  