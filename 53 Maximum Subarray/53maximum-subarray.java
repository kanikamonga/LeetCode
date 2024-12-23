class Solution {
    public int maxSubArray(int[] nums) {
        int global_maxSum = Integer.MIN_VALUE;
        
        //Two Pointers Sliding Window Algorithm
        int windowStart = 0;
        int local_windowSum = 0;
        //windowEnd to iterate the nums array
        for(int windowEnd = 0;windowEnd < nums.length; windowEnd++){
            local_windowSum += nums[windowEnd];
            
            //update global max sum
            if(local_windowSum > global_maxSum) {
                global_maxSum = local_windowSum;
            }
            
            //keep shrink the window if the window sum is negative
            while(local_windowSum < 0){
                local_windowSum = local_windowSum - nums[windowStart];
                windowStart++;
            }
        }
        
        return global_maxSum;
   
    }
}