class Solution {
    public int jump(int[] nums) {
        // ans: Minimum number of jumps needed to reach the end
        // farthest: The farthest index that can be reached so far
        // end: The end of the current jump range
        int ans = 0;
        int farthest = 0;
        int end = 0;

        // Loop through the array (but not including the last element)
        for (int i = 0; i < nums.length - 1; ++i) {
            // Update the farthest index we can reach from current position
            farthest = Math.max(farthest, i + nums[i]);
            // If we've reached the end of the current jump range
            if (i == end) {
                ans++;              // Make a jump
                end = farthest;     // Set new end for the next jump
            }
        }
        return ans;
    }
}