class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Calculate the total sum of all numbers
        int totalSum = Arrays.stream(nums).sum();
      
        // Check if it's possible to achieve the target
        // If total sum is less than target or the difference is odd, it's impossible
        if (totalSum < Math.abs(target) || (totalSum - target) % 2 != 0) {
            return 0;
        }
      
        // Transform the problem into subset sum problem
        // We need to find subsets with sum = (totalSum - target) / 2
        // This comes from: positiveSum - negativeSum = target
        // and positiveSum + negativeSum = totalSum
        // Solving these equations: negativeSum = (totalSum - target) / 2
        int numCount = nums.length;
        int targetSum = (totalSum - target) / 2;
      
        // dp[i][j] represents the number of ways to select from first i numbers
        // to achieve a sum of j
        int[][] dp = new int[numCount + 1][targetSum + 1];
      
        // Base case: empty subset has sum 0, there's one way to achieve it
        dp[0][0] = 1;
      
        // Fill the dp table
        for (int i = 1; i <= numCount; i++) {
            for (int j = 0; j <= targetSum; j++) {
                // Option 1: Don't include the current number
                dp[i][j] = dp[i - 1][j];
              
                // Option 2: Include the current number if possible
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
      
        // Return the number of ways to achieve targetSum using all numbers
        return dp[numCount][targetSum];
    }
}
