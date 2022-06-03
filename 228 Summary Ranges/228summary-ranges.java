class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<>();
        
        StringBuilder s = new StringBuilder();
        
        if(nums.length == 0){
          return result;  
        } 
         if(nums.length == 1){
             result.add(String.valueOf(nums[0]));
          return result;  
        } 
        
        int start = nums[0];
        for(int i=1;i<nums.length;i++){
            while(i<nums.length && nums[i-1] + 1 == nums[i]){
                i++;
            }
           
            if(start == nums[i-1]){
              s = new StringBuilder();
                s.append(start);
                 result.add(s.toString());
            }else{
             s = new StringBuilder();
             s.append(start).append("->").append(nums[i-1]);
                 result.add(s.toString());
          
            }
               if(i<nums.length)
                start = nums[i];
         
            
            if(i==nums.length-1){
                 s = new StringBuilder().append(nums[i]);
                 result.add(s.toString());
            }
            
        }
        
        return result;
        
    }
}