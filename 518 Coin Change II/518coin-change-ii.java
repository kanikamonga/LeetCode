class Solution {
    /**
     * Calculate the number of combinations to make up the amount using given coins.
     * This is a classic unbounded knapsack problem using dynamic programming.
     * 
     * @param amount The target amount to make change for
     * @param coins Array of coin denominations available
     * @return Number of combinations that make up the amount
     */
    public int change(int amount, int[] coins) {
        int numCoins = coins.length;
        int targetAmount = amount;
      
        // dp[i][j] represents the number of ways to make amount j using first i coins
        int[][] dp = new int[numCoins + 1][targetAmount + 1];
      
        // Base case: there's one way to make amount 0 (use no coins)
        dp[0][0] = 1;
      
        // Iterate through each coin type
        for (int i = 1; i <= numCoins; i++) {
            // For each possible amount from 0 to target
            for (int j = 0; j <= targetAmount; j++) {
                // Option 1: Don't use the current coin
                // Number of ways remains same as without this coin
                dp[i][j] = dp[i - 1][j];
              
                // Option 2: Use the current coin (if amount allows)
                // Add the number of ways when we use this coin
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
      
        // Return the number of ways to make the target amount using all coins
        return dp[numCoins][targetAmount];
    }
}
