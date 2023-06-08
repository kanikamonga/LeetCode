class Solution {
    int rows,cols,grid[][];
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1)
                  return  dfs(i,j,new boolean[rows][cols]);
            }
        }
    return 0;
    }


    public int dfs(int i, int j,boolean[][] visit){
        if(i<0||j<0||i==rows||j==cols||  grid[i][j]==0){
            return 1;
        }
        if(visit[i][j]) return 0;
        visit[i][j] = true;

         int perm =   dfs(i+1,j,visit);
         perm+=  dfs(i,j+1,visit);
         perm+=  dfs(i-1,j,visit);
         perm+=  dfs(i,j-1,visit);

         return perm;
    }

}