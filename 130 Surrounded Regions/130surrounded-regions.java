class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(board[i][j] == 'O' ){
                if(i ==0 || i== m-1 || j==0 || j ==n-1){
                    dfs(i,j,board);
                }
                    
                }
            }
        }
                   
          for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
            
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                     board[i][j] = 'X';
                }
            
            }}          
                   
        
    }
    public void dfs(int x,int y,char[][] board){
        int m = board.length;
        int n = board[0].length;
          if(x<0 || x>m-1 || y>n-1 || y<0||board[x][y] == 'X' || board[x][y] == 'T')
            return;
        
      
        board[x][y] = 'T';
        
        int [][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] dir : directions){
         dfs(x+dir[0],y+dir[1],board);

        }
        
    }
                   
}