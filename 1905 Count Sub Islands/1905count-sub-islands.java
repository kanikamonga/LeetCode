class Solution {

    int rows,cols ,grid1[][],grid2[][];
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1; this.grid2 = grid2;
        rows = grid1.length;cols = grid1[0].length;
        boolean[][] visit = new boolean[rows][cols];
            int count = 0;
            for (int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(grid2[i][j] == 1 && !visit[i][j] && dfs(i,j,visit)){
                        count++;                        
                    }
                }
            }
        return count;
    }


    public boolean dfs(int r,int c,boolean[][] visit){

        if(r<0||c<0||r==rows||c==cols||visit[r][c]||grid2[r][c] == 0) return true;

        visit[r][c] = true;
        boolean result = true;
        if(grid1[r][c] == 0)
            result = false;

        result =dfs(r+1,c,visit) && result;
        result =dfs(r-1,c,visit) && result;
        result =dfs(r,c+1,visit) && result;
        result =dfs(r,c-1,visit) && result;
        return result;

    }
}