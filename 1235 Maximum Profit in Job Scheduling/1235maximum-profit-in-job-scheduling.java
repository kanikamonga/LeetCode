class Solution {
    // Store jobs as [startTime, endTime, profit]
    private int[][] jobs;
    // Memoization array to store maximum profit from index i to end
    private int[] memo;
    // Total number of jobs
    private int n;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = profit.length;
        jobs = new int[n][3];

        // Create jobs array with all information combined
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        // Sort jobs by start time in ascending order
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Initialize memoization array
        memo = new int[n];

        // Start DFS from the first job
        return dfs(0);
    }

    /**
     * DFS with memoization to find maximum profit from index i to end
     * @param i current job index
     * @return maximum profit achievable from job i onwards
     */
    private int dfs(int i) {
        // Base case: no more jobs to process
        if (i >= n) {
            return 0;
        }

        // Return memoized result if already computed
        if (memo[i] != 0) {
            return memo[i];
        }

        // Get current job's end time and profit
        int currentEndTime = jobs[i][1];
        int currentProfit = jobs[i][2];

        // Find the next job that starts after current job ends
        int nextJobIndex = search(jobs, currentEndTime, i + 1);

        // Choose maximum between:
        // 1. Skip current job and process next job
        // 2. Take current job and process next compatible job
        int maxProfit = Math.max(dfs(i + 1), currentProfit + dfs(nextJobIndex));

        // Memoize the result
        memo[i] = maxProfit;

        return maxProfit;
    }

    /**
     * Binary search to find the first job whose start time >= targetTime
     * @param jobs sorted array of jobs
     * @param targetTime the time to search for
     * @param startIndex starting index for search
     * @return index of first job with start time >= targetTime, or n if none exists
     */
    private int search(int[][] jobs, int targetTime, int startIndex) {
        int left = startIndex;
        int right = n;

        // Binary search for leftmost position where jobs[mid][0] >= targetTime
        while (left < right) {
            int mid = (left + right) >> 1;  // Equivalent to (left + right) / 2

            if (jobs[mid][0] >= targetTime) {
                // Target might be at mid or to the left
                right = mid;
            } else {
                // Target must be to the right
                left = mid + 1;
            }
        }

        return left;
    }
}
