class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a Map to store the frequency of each number
        Map<Integer, Long> frequencyMap = Arrays.stream(nums)
                                                .boxed() // box the ints to Integers
                                                .collect(Collectors.groupingBy(Function.identity(), // group by the number itself
                                                    Collectors.counting())); // count the frequency
      
        // Initialize a min-heap based on the frequency values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a).compareTo(frequencyMap.get(b)));

        // Iterate over the frequency map
        for (Integer key : frequencyMap.keySet()) {
            // Insert the current entry into the min-heap
            minHeap.offer(key);
          
            // If the heap size exceeds 'k', remove the smallest frequency element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
      
        // Extract the top 'k' frequent numbers from the min-heap into an array
        return minHeap.stream().mapToInt(Integer::intValue).toArray();

    }
}
