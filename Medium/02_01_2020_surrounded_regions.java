/**
 * Time: O(n * m)
 * Space: O(1)
 */
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board == null) return;
        // Change all the O's connected on the edges of the board to a special character because
        // They can never be captured since they can never be completely surrounded. (they are on the edge) 
        for (int row = 0; row < board.length; row++) {
            // Checking left edge
            if (board[row][0] == 'O') {
                change(board, row, 0);
            }
            // Checking right edge
            if(board[row][board[0].length - 1] == 'O') {
                change(board, row, board[0].length - 1);
            }
        }
        for (int col = 0; col < board[0].length; col++) {
            // Checking top edge
            if (board[0][col] == 'O') {
                change(board, 0, col);
            }
            // Checking bottom edge
            if(board[board.length - 1][col] == 'O') {
                change(board, board.length - 1, col);
            }
        }
        // Finally we capture the remaining O's
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                if (board[row][col] == '_') {
                    board[row][col] = 'O';
                }
            }
        }
    }
    /**
     * DFS function to recursively check the connected neighboring cells and change them to a special character
     * if they are O's
     */
    public void change(char[][] board, int row, int col) {
        if (row < 0|| row >= board.length || col < 0 || col >= board[row].length
           || board[row][col] == 'X' || board[row][col] == '_') {
            return;
        }
        board[row][col] = '_';
        // Change all the connected O's to _'s
        change(board, row, col + 1);
        change(board, row, col - 1);
        change(board, row - 1, col);
        change(board, row + 1, col);

    }
}