class Solution {
    int rows,cols; char board[][];
    boolean[][] visit;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;this.word = word;
    rows = board.length; cols = board[0].length;    
     visit = new boolean[rows][cols];

            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(word.charAt(0) == board[i][j] && dfs(i,j,0)){
                        return true;
                    }
                }
            }

    return false;

    }

    public boolean dfs(int r,int c, int k){
        if(k==word.length()) return true;

        if(r<0 || c<0 || r==rows || c==cols || visit[r][c] || word.charAt(k) != board[r][c]){
            return false;
        }

        

        visit[r][c] = true;

        if(dfs(r+1,c,k+1) ||
        dfs(r,c+1,k+1) ||
        dfs(r-1,c,k+1) ||
        dfs(r,c-1,k+1)) return true ;

        visit[r][c] = false;
        return false;
    }



}