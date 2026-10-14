class Solution {
    public int nthUglyNumber(int n) {
        // Use a set to track visited ugly numbers to avoid duplicates
        Set<Long> visitedNumbers = new HashSet<>();
      
        // Min heap to get the smallest ugly number each time
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
      
        // Prime factors that define ugly numbers
        int[] primeFactors = new int[] {2, 3, 5};
      
        // Initialize with 1 (the first ugly number)
        minHeap.offer(1L);
        visitedNumbers.add(1L);
      
        long currentUglyNumber = 0;
      
        // Extract the nth smallest ugly number
        while (n-- > 0) {
            // Get the smallest ugly number from the heap
            currentUglyNumber = minHeap.poll();
          
            // Generate new ugly numbers by multiplying with each prime factor
            for (int factor : primeFactors) {
                long nextUglyNumber = currentUglyNumber * factor;
              
                // Only add to heap if this number hasn't been seen before
                if (visitedNumbers.add(nextUglyNumber)) {
                    minHeap.offer(nextUglyNumber);
                }
            }
        }
      
        // Return the nth ugly number
        return (int) currentUglyNumber;
    }
}
