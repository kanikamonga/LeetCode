class Solution {
    public void moveZeroes(int[] nums) {
        
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] ==0)
                count++;
        }        
 
        int j = 0;
        for(int i=0;i<nums.length;i++){
           if(nums[i] ==0){
               continue;                
           }
            
        System.out.print(j);
        System.out.println(i);
            nums[j] = nums[i];
            j++;
        }        
        
        count = nums.length - count;
        while(count<nums.length)
            nums[count++] = 0;
        
        
        
    }
}