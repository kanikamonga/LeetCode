class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0; // Initialize the maximum reachable index to 0

        // Iterate over each index in the array
        for (int i = 0; i < nums.length; ++i) {
            // If the current index is greater than the maximum reachable index,
            // it means we cannot proceed further, so return false.
            if (maxReachable < i) {
                return false;
            }

            // Update the maximum reachable index if the reachable index
            // from the current position is greater than the previous max.
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
      
        // If the loop completes without returning false, it means we can
        // reach the last index, so return true.
        return true;
    }
}