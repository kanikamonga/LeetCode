class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            if(num<0){
                set.add(num);
            }
        }
         for(int num : nums){
                if(num>0 && set.contains(-num) && num>max){
                    max = num;
                }
         }
         if(max == Integer.MIN_VALUE){
            return -1;

         }
         return max;
    }
}