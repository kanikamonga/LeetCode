class Solution {

    public int maxSubarraySumCircular(int[] nums) {
            // Step 1: Kadane's for max subarray sum without wraparound
int maxSum = nums[0], currMax = nums[0];
        int minSum = nums[0], currMin = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);

            totalSum += nums[i];
        }
            // If all elements are negative, return maxSum
            // Otherwise, return the max of normal and circular sums

        return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum - minSum);
    }
}