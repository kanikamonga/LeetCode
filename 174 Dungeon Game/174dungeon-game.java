class Solution {
    // 7  5  2 I
    // 6  11 5 I
    // 1  1  6 1
    // I  I 1 I

    public int calculateMinimumHP(int[][] dungeon) {
          int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int[] cur : dp){
            Arrays.fill(cur, Integer.MAX_VALUE);
        }
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        for (int i=m-1; i>=0; i--){
            for (int j=n-1; j>=0; j--){
                int res = Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j];
                dp[i][j] = res < 1 ? 1 : res;
                System.out.println("i= "+i+" j = "+j+", dp = "+dp[i][j]);
            }
        }
        return dp[0][0];
    }
}