/**
 * Time: O(1) -> There are 81 total cells to iterate over and in Big-O notation, we drop constants
 * Space: O(1) -> Our hash maps all have a finite number of elements they can store (we drop constants)
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer> [] rows = new HashMap[9];
        Map<Integer, Integer> [] columns = new HashMap[9];
        Map<Integer, Integer> [] boxes = new HashMap[9];
        
        for (int i = 0; i < 9; i++) {
            // Initialize one hash map for each row and column and sub grid
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();

        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char current = board[i][j];
                if (current != '.') {
                    int num = (int) current;
                    int boxIndex = (i / 3) * 3 + j / 3;
                    
                    
                    // Update how many times weve seen this num in this row and col
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                    boxes[boxIndex].put(num, boxes[boxIndex].getOrDefault(num, 0) + 1);
                    
                    // Checking whether this number is duplicated
                    if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || 
                        boxes[boxIndex].get(num) > 1) {
                        return false;
                    }
                    
                    // this code is theoretically faster
                    // int subGridRowStart = (i / 3) * 3;
                    // int subGridColStart = (j / 3) * 3;
                    // for (int l = 0; l < 3; l++){
                    //     for (int m = 0; m < 3; m++) {
                    //         if (i != subGridRowStart + l && j != subGridColStart + m &&
                    //            board[subGridRowStart + l][subGridColStart + m] == board[i][j]) {
                    //             // We've seen this char
                    //             return false;
                    //         }
                    //     }
                    // }
                    
                }
            }
        }
        return true;
    }
}

// Visualizing an array of maps
// [
//     ( (x:y), (x:y), (x:y) ), // row[0]
//     ( (x:y), (x:y), (x:y) ), // row[1]
//     ( (x:y), (x:y), (x:y) ), // row[2]
// ]