class Solution {
    public int maxProduct(int[] nums) {

        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i=0;i<n;i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix = nums[i]* prefix;
            suffix = nums[n-i-1]*suffix;
            max = Math.max(max,Math.max(prefix,suffix));

        }

        return max;
        
    }
}