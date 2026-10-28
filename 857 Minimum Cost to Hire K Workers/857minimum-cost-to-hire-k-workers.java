class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
      
        // Create array of workers with their wage/quality ratio and quality
        // Each worker is represented as a pair: (wage/quality ratio, quality)
        Pair<Double, Integer>[] workers = new Pair[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Pair<>((double) wage[i] / quality[i], quality[i]);
        }
      
        // Sort workers by their wage/quality ratio in ascending order
        // Workers with lower ratios come first
        Arrays.sort(workers, (a, b) -> Double.compare(a.getKey(), b.getKey()));
      
        // Max heap to maintain the k workers with smallest quality values
        // We use max heap to easily remove the worker with highest quality
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
      
        double minCost = Double.MAX_VALUE;
        int totalQuality = 0;
      
        // Iterate through workers sorted by wage/quality ratio
        for (Pair<Double, Integer> worker : workers) {
            double ratio = worker.getKey();
            int workerQuality = worker.getValue();
          
            // Add current worker's quality to total and heap
            totalQuality += workerQuality;
            maxHeap.offer(workerQuality);
          
            // When we have exactly k workers, calculate the cost
            if (maxHeap.size() == k) {
                // Cost = total quality * current worker's ratio
                // Current worker has the highest ratio among selected workers
                minCost = Math.min(minCost, totalQuality * ratio);
              
                // Remove the worker with highest quality to make room for next iteration
                totalQuality -= maxHeap.poll();
            }
        }
      
        return minCost;
    }
}
