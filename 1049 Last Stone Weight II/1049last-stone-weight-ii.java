class Solution {
    public int lastStoneWeightII(int[] stones) {
        // Calculate the total sum of all stones
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }
      
        // Number of stones
        int numStones = stones.length;
      
        // Target capacity is half of total sum
        // We want to find a subset with sum as close to totalSum/2 as possible
        int targetCapacity = totalSum / 2;
      
        // dp[i][j] represents the maximum sum we can achieve using first i stones
        // with sum not exceeding j
        int[][] dp = new int[numStones + 1][targetCapacity + 1];
      
        // Fill the dp table using 0/1 knapsack approach
        for (int i = 1; i <= numStones; i++) {
            for (int j = 0; j <= targetCapacity; j++) {
                // Option 1: Don't include current stone
                dp[i][j] = dp[i - 1][j];
              
                // Option 2: Include current stone if it fits
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], 
                                       dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
      
        // The minimum difference is (totalSum - subset1Sum) - subset1Sum
        // which equals totalSum - 2 * subset1Sum
        // where subset1Sum is the maximum sum not exceeding totalSum/2
        return totalSum - dp[numStones][targetCapacity] * 2;
    }
}
