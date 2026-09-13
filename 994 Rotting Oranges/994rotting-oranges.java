class Solution {
    public int orangesRotting(int[][] grid) {
        
        int freshCount = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer[]> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    freshCount++;
                }
                else if (grid[i][j] == 2){
                    q.offer(new Integer[]{i,j});
                }
            }
        }

            int dir [] = new int[]{-1,0,1,0,-1};

            for(int min = 1;freshCount>0 && !q.isEmpty();min++){
                int size = q.size();

                for(int s = 0;s<size;s++){

                Integer[] currentPosition = q.poll();
                int r = currentPosition[0];
                int c = currentPosition[1];

                for(int d = 0;d<dir.length-1;d++){
                    int nr = r+dir[d];
                    int nc = c+dir[d+1];
                   if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    freshCount--;
                    q.offer(new Integer[]{nr,nc});
                    if(freshCount ==0){
                        return min;
                    }
                   }     

                }

                }    
            }

            return freshCount>0?-1:0;

        }


    
}