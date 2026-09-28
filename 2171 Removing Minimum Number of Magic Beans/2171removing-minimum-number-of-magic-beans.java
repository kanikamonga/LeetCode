class Solution {
    public long minimumRemoval(int[] beans) {
        // Sort the array to consider each value as a potential target height
        Arrays.sort(beans);
      
        // Calculate the total sum of all beans
        long totalSum = 0;
        for (int bean : beans) {
            totalSum += bean;
        }
      
        // Initialize minimum removals with the total sum (worst case: remove all beans)
        long minRemovals = totalSum;
        int length = beans.length;
      
        // Try each unique bean value as the target height
        for (int i = 0; i < length; ++i) {
            // Calculate removals if we make all non-empty bags have beans[i] beans
            // Formula: totalSum - (targetHeight * numberOfBagsToKeep)
            // numberOfBagsToKeep = length - i (all bags from index i to end)
            long currentRemovals = totalSum - (long) beans[i] * (length - i);
            minRemovals = Math.min(minRemovals, currentRemovals);
        }
      
        return minRemovals;
    }
}
