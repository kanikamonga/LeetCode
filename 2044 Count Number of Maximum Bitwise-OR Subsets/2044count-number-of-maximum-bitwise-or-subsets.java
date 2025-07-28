class Solution {
    int maxOr = 0; // Maximum OR value that any subset can achieve
    int count = 0; // Count of subsets whose OR is equal to maxOr

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Calculate the maximum OR value from all elements
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Start DFS to explore all subsets
        dfs(nums, 0, 0);

        // Step 3: Return the total count
        return count;
    }

    // Recursive DFS to explore all subsets
    private void dfs(int[] nums, int index, int currOr) {
        // Base case: If we've considered all elements
        if (index == nums.length) {
            // Check if the current OR is equal to maxOr
            if (currOr == maxOr) {
                count++; // Valid subset found
            }
            return;
        }

        // Recursive case 1: Include nums[index] in the OR
        dfs(nums, index + 1, currOr | nums[index]);

        // Recursive case 2: Exclude nums[index] from the OR
        dfs(nums, index + 1, currOr);
    }
}