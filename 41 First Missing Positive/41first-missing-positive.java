class Solution {
    public int firstMissingPositive(int[] nums) {
         int i = 0;
        while (i < nums.length) {
            int correctSpot = nums[i] - 1;
            if (correctSpot >= 0 && correctSpot < nums.length && nums[i] != nums[correctSpot]) {
                int temp = nums[i];
                nums[i] = nums[correctSpot];
                nums[correctSpot] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }
}