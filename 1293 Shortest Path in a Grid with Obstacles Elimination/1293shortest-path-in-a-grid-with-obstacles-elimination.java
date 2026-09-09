class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
      
        // Optimization: if we have enough eliminations to go straight through obstacles
        // The minimum obstacles in any path is at most (rows - 1) + (cols - 1) - 1
        if (k >= rows + cols - 3) {
            return rows + cols - 2;
        }
      
        // BFS queue storing [row, col, remaining eliminations]
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, k});
      
        // 3D visited array: visited[row][col][remainingEliminations]
        boolean[][][] visited = new boolean[rows][cols][k + 1];
        visited[0][0][k] = true;
      
        // Track the number of steps taken
        int steps = 0;
      
        // Direction vectors for moving up, right, down, left
        int[] directions = {-1, 0, 1, 0, -1};
      
        // BFS to find shortest path
        while (!queue.isEmpty()) {
            steps++;
          
            // Process all cells at current distance level
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentCol = current[1];
                int remainingEliminations = current[2];
              
                // Explore all 4 directions
                for (int j = 0; j < 4; j++) {
                    int nextRow = currentRow + directions[j];
                    int nextCol = currentCol + directions[j + 1];
                  
                    // Check if next position is within grid bounds
                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                        // Check if we reached the destination
                        if (nextRow == rows - 1 && nextCol == cols - 1) {
                            return steps;
                        }
                      
                        // If next cell is empty and not visited with current elimination count
                        if (grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol][remainingEliminations]) {
                            queue.offer(new int[] {nextRow, nextCol, remainingEliminations});
                            visited[nextRow][nextCol][remainingEliminations] = true;
                        }
                        // If next cell is obstacle, we have eliminations left, and not visited with reduced count
                        else if (grid[nextRow][nextCol] == 1 && remainingEliminations > 0 
                                && !visited[nextRow][nextCol][remainingEliminations - 1]) {
                            queue.offer(new int[] {nextRow, nextCol, remainingEliminations - 1});
                            visited[nextRow][nextCol][remainingEliminations - 1] = true;
                        }
                    }
                }
            }
        }
      
        // No path found to destination
        return -1;
    }
}
