class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length/2;
        int res = 0;
        while(start<nums.length/2 && end<nums.length){
            if(nums[start]*2<=nums[end]){
                start++;
                end++;
                res+=2;
                continue;
            }
            end++;
        }
        return res;
    }
    
}