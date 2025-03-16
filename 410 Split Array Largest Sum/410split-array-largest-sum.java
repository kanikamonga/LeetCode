class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        
        // Determine the search range: 
        // 'low' is the max element, 'high' is the sum of all elements
        for (int num : nums) {
            low = Math.max(low, num); // max element in array
            high += num; // sum of all elements
        }

        // Binary search on possible largest sum
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) { // Check feasibility
                high = mid - 1; // Try for a smaller sum
            } else {
                low = mid + 1; // Increase sum limit
            }
        }
        return low; // Final minimized largest sum
    }

    // Helper function to check if we can split 'nums' into 'k' subarrays 
    // without exceeding 'maxSum' in any subarray.
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int sum = 0, subarrays = 1;
        
        for (int num : nums) {
            if (sum + num > maxSum) {
                subarrays++; // Start a new subarray
                sum = num;   // Reset sum to current number
                if (subarrays > k) return false; // Too many subarrays
            } else {
                sum += num; // Continue adding to current subarray
            }
        }
        return true; // Successfully split into 'k' or fewer subarrays
    }
}