/**
 * Time: O(n) -> where n is the number of cells in the grid
 * Space: O(d) -> where d is the depth of the deepest path
 */
class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    // Run a dfs on this instance of 0 because it could be a
                    // Potential island
                    boolean closed = isClosed(grid, i, j);
                    if (closed) count += 1;
                }
            }
        }
        return count;
    }
    public boolean isClosed(int[][] grid, int row, int col) {
        // Base case: If we're out of bounds, return false.
        if (row < 0 || row >= grid.length || col < 0 ||
           col >= grid[row].length) {
            return false;
        }
        // Stop traversing this path and return true if we see 1
        if (grid[row][col] == 1) return true;
        
        // Change the value to 1, so we don't come here again
        grid[row][col] = 1;
        
        // Check this cell's 4 neighbors
        boolean bottom = isClosed(grid, row + 1, col); // bottom
        boolean right = isClosed(grid, row, col + 1); // right
        boolean left = isClosed(grid, row, col - 1); // left
        boolean top = isClosed(grid, row - 1, col); // top;
        
        // Check that all 4 neighbors (paths) return true
        return bottom && right && top && left;
    }
}