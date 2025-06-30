class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums); 
        int start = 0, end = nums.length - 1;
        long count = 0;
        int MOD = 1_000_000_007;

        // Precompute exponent
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] * 2) % MOD; 
        }

        while (start <= end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else {
                count = (count + power[end - start]) % MOD;
                start++; 
            }
        }
        return (int) count; 
    }
}