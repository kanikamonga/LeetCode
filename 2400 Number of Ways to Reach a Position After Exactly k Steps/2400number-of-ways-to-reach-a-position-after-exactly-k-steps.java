class Solution {
    // Memoization table to store computed results
    // memo[distance][stepsRemaining] = number of ways to reach distance 0 from current distance with given steps
    private Integer[][] memo;
  
    // Modulo value for preventing integer overflow
    private static final int MOD = (int) 1e9 + 7;

    /**
     * Calculates the number of ways to move from startPos to endPos in exactly k steps.
     * Each step can move either left (-1) or right (+1).
     * 
     * @param startPos Starting position
     * @param endPos Target ending position
     * @param k Number of steps to take
     * @return Number of ways to reach endPos from startPos in k steps, modulo 10^9 + 7
     */
    public int numberOfWays(int startPos, int endPos, int k) {
        // Initialize memoization table
        // Size is (k+1) x (k+1) to handle all possible distances and steps
        memo = new Integer[k + 1][k + 1];
      
        // Calculate initial distance and find number of ways using DFS
        int initialDistance = Math.abs(startPos - endPos);
        return dfs(initialDistance, k);
    }

    /**
     * Recursive helper function using dynamic programming with memoization.
     * Calculates number of ways to reach distance 0 from current distance with given steps.
     * 
     * @param currentDistance Current distance from target (always non-negative)
     * @param stepsRemaining Number of steps remaining
     * @return Number of ways to reach distance 0 with given steps
     */
    private int dfs(int currentDistance, int stepsRemaining) {
        // Base case: Invalid state - distance too large for remaining steps or negative steps
        if (currentDistance > stepsRemaining || stepsRemaining < 0) {
            return 0;
        }
      
        // Base case: No steps remaining
        if (stepsRemaining == 0) {
            // Return 1 if we reached the target (distance = 0), otherwise 0
            return currentDistance == 0 ? 1 : 0;
        }
      
        // Check memoization table for previously computed result
        if (memo[currentDistance][stepsRemaining] != null) {
            return memo[currentDistance][stepsRemaining];
        }
      
        // Calculate number of ways by considering both possible moves:
        // 1. Move away from target: distance increases by 1
        // 2. Move toward target: distance decreases by 1 (use abs to handle distance becoming negative)
        int waysMovingAway = dfs(currentDistance + 1, stepsRemaining - 1);
        int waysMovingToward = dfs(Math.abs(currentDistance - 1), stepsRemaining - 1);
      
        // Sum the ways and apply modulo to prevent overflow
        int totalWays = (waysMovingAway + waysMovingToward) % MOD;
      
        // Store result in memoization table and return
        memo[currentDistance][stepsRemaining] = totalWays;
        return totalWays;
    }
}