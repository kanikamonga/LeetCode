class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
      
        // dp[i] represents the length of the longest increasing subsequence ending at index i
        int[] dp = new int[n];
      
        // count[i] represents the number of longest increasing subsequences ending at index i
        int[] count = new int[n];
      
        // Track the maximum length and the total count of all longest increasing subsequences
        int maxLength = 0;
        int result = 0;
      
        // Process each element as a potential end of an increasing subsequence
        for (int i = 0; i < n; i++) {
            // Initialize: each element itself forms a subsequence of length 1
            dp[i] = 1;
            count[i] = 1;
          
            // Check all previous elements to build longer subsequences
            for (int j = 0; j < i; j++) {
                // Only consider if we can extend the subsequence (increasing order)
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        // Found a longer subsequence ending at i
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];  // Inherit the count from j
                    } else if (dp[i] == dp[j] + 1) {
                        // Found another way to form the same length subsequence
                        count[i] += count[j];  // Add the count from j
                    }
                }
            }
          
            // Update global maximum length and count
            if (maxLength < dp[i]) {
                // Found a new maximum length
                maxLength = dp[i];
                result = count[i];
            } else if (maxLength == dp[i]) {
                // Found another subsequence with the same maximum length
                result += count[i];
            }
        }
      
        return result;
    }
}
