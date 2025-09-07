class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
          int rows = maze.length;
        int cols = maze[0].length;
      
        // Direction vectors for moving up, right, down, left
        // Using pairs: (-1,0), (0,1), (1,0), (0,-1)
        final int[] directions = {-1, 0, 1, 0, -1};
      
        // Initialize BFS queue with the entrance position
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
      
        // Mark entrance as visited by changing it to '+'
        maze[entrance[0]][entrance[1]] = '+';
      
        // BFS to find shortest path to exit
        // Start with distance 1 (entrance doesn't count as a step)
        for (int distance = 1; !queue.isEmpty(); distance++) {
            // Process all cells at current distance level
            int currentLevelSize = queue.size();
          
            for (int i = 0; i < currentLevelSize; i++) {
                // Get current position from queue
                int[] currentPosition = queue.poll();
              
                // Try all 4 directions
                for (int dir = 0; dir < 4; dir++) {
                    // Calculate new position
                    int newRow = currentPosition[0] + directions[dir];
                    int newCol = currentPosition[1] + directions[dir + 1];
                  
                    // Check if new position is valid and is an empty cell
                    if (newRow >= 0 && newRow < rows && 
                        newCol >= 0 && newCol < cols && 
                        maze[newRow][newCol] == '.') {
                      
                        // Check if this position is an exit (on the border)
                        if (newRow == 0 || newRow == rows - 1 || 
                            newCol == 0 || newCol == cols - 1) {
                            return distance;
                        }
                      
                        // Mark as visited and add to queue for further exploration
                        maze[newRow][newCol] = '+';
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
      
        // No exit found
        return -1;
    }
}