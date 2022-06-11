class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int result = 0,min=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            int j = i+1, k = nums.length-1;
            
            while(j<k){
                
                int sum = nums[i]+nums[j]+nums[k];
                
                int diff = Math.abs(sum - target);
                if(diff == 0) return sum;
                
                if(diff<min){
                   result = sum;
                    min = diff;
                  
                }
               if (sum <= target) {
			        j++;
		        } else {
		        	k--;
		        }
            }
            
        }
        
        return result;
    }
}