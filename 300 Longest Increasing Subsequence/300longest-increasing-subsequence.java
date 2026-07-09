class Solution {
    /**
     * Finds the length of the longest increasing subsequence in the given array.
     * Uses dynamic programming approach where dp[i] represents the length of 
     * the longest increasing subsequence ending at index i.
     * 
     * @param nums the input array of integers
     * @return the length of the longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
      
        // dp[i] stores the length of the longest increasing subsequence ending at index i
        int[] dp = new int[n];
      
        // Initialize all positions with 1 (each element is a subsequence of length 1)
        Arrays.fill(dp, 1);
      
        // Track the maximum length found so far
        int maxLength = 1;
      
        // For each position i, check all previous positions j
        for (int i = 1; i < n; i++) {
            // Check all elements before current position
            for (int j = 0; j < i; j++) {
                // If nums[j] < nums[i], we can extend the subsequence ending at j
                if (nums[j] < nums[i]) {
                    // Update dp[i] to be the maximum of current value or extending from j
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Update the global maximum length
            maxLength = Math.max(maxLength, dp[i]);
        }
      
        return maxLength;
    }
}
