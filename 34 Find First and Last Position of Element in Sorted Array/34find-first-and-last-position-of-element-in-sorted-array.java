class Solution {
    public int[] searchRange(int[] nums, int target) {

        int []result = new int[2];
        int i=0,start = -1,end = -1;
        while(i<nums.length){
            if(nums[i] == target){
                if(start==-1) start = i;
                end = i;
            }
            if(nums[i]>target) break;
            i++;
        }

        result[0] = start;
        result[1] = end;
        return result;
    }
}