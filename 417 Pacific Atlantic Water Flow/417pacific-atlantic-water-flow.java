class Solution { // 5ms - 92.80% Faster
    int rows,cols;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
            this.heights=heights;

             rows = heights.length;
             cols = heights[0].length;

             List<List<Integer>> res = new ArrayList<>();

            boolean[][] pac = new boolean[rows][cols],atl = new boolean[rows][cols];

            for(int i=0;i<rows;i++){
              dfs(i,0,pac,heights[i][0]);
              dfs(i,cols-1,atl,heights[i][cols-1]);
            }

              for(int j=0;j<cols;j++){
              dfs(0,j,pac,heights[0][j]);
              dfs(rows-1,j,atl,heights[rows-1][j]);
            }

            for (int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(pac[i][j] && atl[i][j]){
                          res.add(Arrays.asList(i,j));  
                    }
                }
            }
            

        return res;
    
    }


    public  void dfs(int r, int c , boolean [][] visit, int prevHeight){
        //check reverse height condition to see if prevCell can receive water from next cell.
        if(r<0 || c<0 || r==rows||c==cols ||visit[r][c] || heights[r][c]< prevHeight) {
            return;
        }

       visit[r][c] = true;

        dfs(r+1,c,visit,heights[r][c]);
        dfs(r,c+1,visit,heights[r][c]);
        dfs(r-1,c,visit,heights[r][c]);
        dfs(r,c-1,visit,heights[r][c]);

    }


}