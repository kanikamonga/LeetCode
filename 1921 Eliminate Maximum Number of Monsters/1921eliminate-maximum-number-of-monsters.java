class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
      
        // Calculate arrival time for each monster (in minutes)
        // Using ceiling division: (dist[i] - 1) / speed[i] gives us the last full minute before arrival
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (dist[i] - 1) / speed[i];
        }
      
        // Sort monsters by their arrival time (earliest first)
        Arrays.sort(arrivalTimes);
      
        // Check if we can eliminate all monsters before they arrive
        // At minute i, we can eliminate the (i+1)th monster
        for (int i = 0; i < n; i++) {
            // If monster arrives before or at minute i, but we can only shoot it at minute i
            // This means the monster reaches us before we can eliminate it
            if (arrivalTimes[i] < i) {
                return i;  // Return the number of monsters eliminated before losing
            }
        }
      
        // All monsters can be eliminated successfully
        return n;
    }
}
