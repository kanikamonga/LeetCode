class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals by their start time in ascending order
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Initialize the first interval's start and end points
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        // List to store merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();

        // Iterate through all intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // Check if current interval and next interval overlap
            if (currentEnd < nextStart) {
                // No overlap: add current merged interval to result
                mergedIntervals.add(new int[] {currentStart, currentEnd});
                // Update current interval to the next one
                currentStart = nextStart;
                currentEnd = nextEnd;
            } else {
                // Overlap exists: merge by extending the end point if necessary
                currentEnd = Math.max(currentEnd, nextEnd);
            }
        }

        // Add the last merged interval to the result
        mergedIntervals.add(new int[] {currentStart, currentEnd});

        // Convert list to 2D array and return
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
