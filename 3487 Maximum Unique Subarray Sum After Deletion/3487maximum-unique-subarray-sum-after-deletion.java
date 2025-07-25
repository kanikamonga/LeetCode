class Solution {

    public int maxSum(int[] nums) {
        Set<Integer> positiveNumsSet = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (num > 0) {
                if(!positiveNumsSet.contains(num)){
                    positiveNumsSet.add(num);
                    sum+=num;
            }
            }else{
                max = Math.max(max,num);
            }
        }
        if (positiveNumsSet.isEmpty()) {
            return max;
        }
        return sum;
    }
}