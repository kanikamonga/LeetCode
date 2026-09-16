class MedianFinder {
    // Min heap to store the larger half of numbers
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  
    // Max heap to store the smaller half of numbers
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    /**
     * Initialize the MedianFinder data structure.
     * Uses two heaps to maintain the median efficiently:
     * - maxHeap: stores the smaller half (max element at top)
     * - minHeap: stores the larger half (min element at top)
     */
    public MedianFinder() {
    }

    /**
     * Adds a number from the data stream to the data structure.
     * Maintains the invariant that:
     * 1. All elements in maxHeap <= all elements in minHeap
     * 2. The size difference between heaps is at most 1
     * 3. If odd total elements, minHeap has one extra element
     * 
     * @param num the number to be added
     */
    public void addNum(int num) {
        // First add to maxHeap (smaller half)
        maxHeap.offer(num);
      
        // Move the largest element from maxHeap to minHeap to maintain order
        minHeap.offer(maxHeap.poll());
      
        // Balance the heaps - ensure minHeap doesn't have more than 1 extra element
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    /**
     * Returns the median of all elements added so far.
     * If even number of elements: returns average of middle two elements
     * If odd number of elements: returns the middle element (from minHeap)
     * 
     * @return the median as a double value
     */
    public double findMedian() {
        return minHeap.size() == maxHeap.size() 
            ? (minHeap.peek() + maxHeap.peek()) / 2.0 
            : minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
