class Solution {
    public boolean isPossible(int[] nums) {
        
   Map<Integer,Integer> FM = new HashMap<>();
        Map<Integer,Integer> HM = new HashMap<>();

        for(int num : nums){
            FM.put(num,FM.getOrDefault(num,0) + 1);
        }
        
        for(int i : nums){

            if(FM.get(i) == 0) continue;

            if(HM.getOrDefault(i,0) > 0){
                HM.put(i, HM.get(i) - 1);
                HM.put(i + 1, HM.getOrDefault(i + 1, 0) + 1);
                FM.put(i, FM.get(i) - 1);
            }
            else if((FM.getOrDefault(i,0) > 0)&& (FM.getOrDefault(i + 1 , 0) > 0) && (FM.getOrDefault(i + 2 , 0) > 0)){
                FM.put(i , FM.get(i) - 1);
                FM.put(i + 1, FM.get(i + 1) - 1);
                FM.put(i + 2, FM.get(i + 2) - 1);
                HM.put(i + 3, HM.getOrDefault(i + 3, 0) + 1);
            }else{
                return false;
            }
        }
        return true;
    }
}