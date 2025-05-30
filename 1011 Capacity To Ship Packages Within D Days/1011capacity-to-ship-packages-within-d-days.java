class Solution {
    public int shipWithinDays(int[] weights, int days) {
         int left = 0, right = 0;

        // The minimum capacity must be at least the heaviest package
        // The maximum capacity is the sum of all weights
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // Binary search between left and right
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShipInDays(weights, days, mid)) {
                right = mid;  // Try a smaller capacity
            } else {
                left = mid + 1;  // Need a larger capacity
            }
        }

        return left;  // or right (they are equal here)
    }

    // Check if we can ship all packages with given capacity in 'days'
    private static boolean canShipInDays(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int requiredDays = 1;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }

        return requiredDays <= days;
    }
}