public class rotate_matrix {
    
}
import java.util.*;
public class MyClass {
    public static void main(String args[]) {

      int[][] matrix = new int[][] {
          {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9}
      };
      int[][] ans = rotateMatrix(matrix);
      for (int[] row: ans) {
          System.out.println(Arrays.toString(row));
      }
      
   
    }
    public static int[][] rotateMatrix(int[][] matrix) {
        // Step 1: Transpose matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Flip horizontally
        for (int[] row : matrix) {
            int left = 0;
            int right = row.length - 1;
            while (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
        return matrix;
        
    }
    
}