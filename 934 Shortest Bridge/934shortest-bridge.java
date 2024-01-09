class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        boolean [][] visited = new boolean[n][n];

        boolean found = false;
        for(int i = 0; i < n && !found; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, n, i, j, queue,visited);
                    found = true;
                    break;
                }
            }
        }

         int distance = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();  
                for(int[] dirs: directions) {
                    int x = cur[0] + dirs[0];
                    int y = cur[1] + dirs[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y]) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return distance;
                    }
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            distance += 1;
        }
        return -1;



    }

      public void dfs(int[][] grid, int n, int i, int j, Queue<int[]> queue,boolean[][] visited) {
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || visited[i][j])
            return;
        
        queue.add(new int[]{i, j});

        visited[i][j] = true;
        dfs(grid, n, i + 1, j, queue,visited);
        dfs(grid, n, i, j + 1, queue,visited);
        dfs(grid, n, i - 1, j, queue,visited);
        dfs(grid, n, i, j - 1, queue,visited);
    }
}