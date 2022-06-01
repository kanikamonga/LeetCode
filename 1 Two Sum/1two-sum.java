import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
            
        }

        
        for(int j=0;j<nums.length;j++){
            int index = map.getOrDefault(target-nums[j],-1);
            if(index!=-1 && index!=j){
                result[0] = index;
                result[1] = j;
            }
        }
        
        return result;
    }
}