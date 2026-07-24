class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Get matrix dimensions
        int rows = matrix.length;
        int cols = matrix[0].length;
      
        // Direction vectors: right(0,1), down(1,0), left(0,-1), up(-1,0)
        // Stored as: [rowDelta1, colDelta1, rowDelta2, colDelta2, ...]
        int[] directions = {0, 1, 0, -1, 0};
      
        // Current position and direction index
        int currentRow = 0;
        int currentCol = 0;
        int directionIndex = 0; // 0=right, 1=down, 2=left, 3=up
      
        // Result list to store spiral order elements
        List<Integer> result = new ArrayList<>();
      
        // Track visited cells to know when to turn
        boolean[][] visited = new boolean[rows][cols];
      
        // Traverse all cells in the matrix
        int totalCells = rows * cols;
        for (int count = 0; count < totalCells; count++) {
            // Add current cell value to result
            result.add(matrix[currentRow][currentCol]);
          
            // Mark current cell as visited
            visited[currentRow][currentCol] = true;
          
            // Calculate next position based on current direction
            int nextRow = currentRow + directions[directionIndex];
            int nextCol = currentCol + directions[directionIndex + 1];
          
            // Check if we need to change direction (hit boundary or visited cell)
            if (nextRow < 0 || nextRow >= rows || 
                nextCol < 0 || nextCol >= cols || 
                visited[nextRow][nextCol]) {
                // Turn clockwise to next direction
                directionIndex = (directionIndex + 1) % 4;
            }
          
            // Move to next position using current direction
            currentRow += directions[directionIndex];
            currentCol += directions[directionIndex + 1];
        }
      
        return result;
    }
}
