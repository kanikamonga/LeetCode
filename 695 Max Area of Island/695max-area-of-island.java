class Solution {
    // Grid dimensions
    private int rows;
    private int cols;
    private int[][] grid;

    /**
     * Finds the maximum area of an island in the given grid.
     * An island is a group of 1's (representing land) connected horizontally or vertically.
     * 
     * @param grid 2D array where 1 represents land and 0 represents water
     * @return The maximum area among all islands
     */
    public int maxAreaOfIsland(int[][] grid) {
        // Initialize grid dimensions
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
      
        int maxArea = 0;
      
        // Iterate through each cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(grid[row][col]==1)
                // Calculate area for each potential island and track maximum
                maxArea = Math.max(maxArea, dfs(row, col));
            }
        }
      
        return maxArea;
    }

    /**
     * Performs depth-first search to calculate the area of an island.
     * Marks visited cells by setting them to 0.
     * 
     * @param row Current row index
     * @param col Current column index
     * @return Area of the island starting from the current cell
     */
    private int dfs(int row, int col) {
        // Base case: if current cell is water, return 0
        if (grid[row][col] == 0) {
            return 0;
        }
      
        // Count current land cell
        int area = 1;
      
        // Mark current cell as visited by setting it to 0
        grid[row][col] = 0;
      
        // Direction vectors for exploring 4 adjacent cells (up, right, down, left)
        int[] directions = {-1, 0, 1, 0, -1};
      
        // Explore all 4 adjacent cells
        for (int k = 0; k < 4; k++) {
            int nextRow = row + directions[k];
            int nextCol = col + directions[k + 1];
          
            // Check if the next cell is within bounds
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                // Recursively calculate area of connected land cells
                area += dfs(nextRow, nextCol);
            }
        }
      
        return area;
    }
}