class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
      
        // Initialize all elements to -1 (default when no greater element exists)
        Arrays.fill(result, -1);
      
        // Stack to maintain potential next greater elements in decreasing order
        Stack<Integer> stack = new Stack<>();
      
        // Traverse the array twice (circular array simulation)
        // Start from the end and move backwards
        for (int i = length * 2 - 1; i >= 0; i--) {
            // Get the actual index in the original array
            int currentIndex = i % length;
          
            // Remove elements from stack that are less than or equal to current element
            // These cannot be the next greater element for current position
            while (!stack.isEmpty() && stack.peek() <= nums[currentIndex]) {
                stack.pop();
            }
          
            // If stack is not empty, the top element is the next greater element
            // Only update result in the first pass (when i < length)
            if (!stack.isEmpty() && i < length) {
                result[currentIndex] = stack.peek();
            }
          
            // Push current element onto stack as it might be next greater for previous elements
            stack.push(nums[currentIndex]);
        }
      
        return result;
    }
}