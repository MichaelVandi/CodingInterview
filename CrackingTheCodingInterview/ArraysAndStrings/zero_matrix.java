import java.util.*;
public class MyClass {
    public static void main(String args[]) {
    }
    public static void zeroMatrix(int[][] matrix) {
        // Keep tract of whether a row or col has 0 with these boolean arrays
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // This row and col should be nullified
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        // Now iterate through rows and cols and nullify them
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == true) {
                // Set this row to 0's
                nullifyRow(matrix, i);
            }
        }
        
        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == true) {
                // Set this col to 0's
                nullifyCol(matrix, i);
            }
        }
        
        
        
    }
    /*
    
        The following is the optimized function
    */
    public static void zeroMatrixOptimized(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        // Check whether first row and col have 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                // This row has 0
                firstRowHasZero = true;
                break;
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                // This col has 0
                firstColHasZero = true;
                break;
            }
        }
        // Now check for zeros in the rest of the array and store the state in the first
        // Row and col
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // This row and col should be nullified
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // Then we can nullify the rows and cols based on the values of the first row
        // And first col
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                // Nullify this row
                nullifyRow(matrix, i);
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                // Nullify this col
                nullifyCol(matrix, i);
            }
        }
        
        // Now check if first row and col had 0 initially and nullify them as well
        if (firstRowHasZero) {
            nullifyRow(matrix, 0);
        }
        if (firstColHasZero) {
            nullifyCol(matrix, 0);
        }
        
    }
    public static void nullifyRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = 0;
        }
    }
    public static void nullifyCol(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }
    
}