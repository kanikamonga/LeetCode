class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        // Stack to store indices of temperatures in descending order
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[length];
      
        // Traverse the array from right to left
        for (int currentIndex = length - 1; currentIndex >= 0; currentIndex--) {
            // Remove all indices from stack where temperature is less than or equal to current
            // These temperatures cannot be the next warmer day for current index
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[currentIndex]) {
                stack.pop();
            }
          
            // If stack is not empty, top element is the index of next warmer temperature
            // Calculate the difference in days
            if (!stack.isEmpty()) {
                result[currentIndex] = stack.peek() - currentIndex;
            }
            // If stack is empty, result[currentIndex] remains 0 (default value)
          
            // Push current index to stack for future comparisons
            stack.push(currentIndex);
        }
      
        return result;
    }
}
