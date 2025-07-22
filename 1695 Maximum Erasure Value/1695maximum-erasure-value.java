class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;
        
        for (int right = 0; right < n; right++) {
            while (set.contains(nums[right])) {
                currentSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            currentSum += nums[right];
            set.add(nums[right]);
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        return maxSum;
    }
}