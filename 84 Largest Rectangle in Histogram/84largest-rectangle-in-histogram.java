class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
      
        // Stack to maintain indices of heights in increasing order
        Deque<Integer> stack = new ArrayDeque<>();
      
        // Arrays to store the nearest smaller element indices
        // left[i]: index of the nearest smaller element to the left of i (-1 if none)
        int[] left = new int[n];
        // right[i]: index of the nearest smaller element to the right of i (n if none)
        int[] right = new int[n];
        Arrays.fill(right, n);
      
        // Single pass to find both left and right boundaries
        for (int i = 0; i < n; i++) {
            // Pop elements from stack that are greater than or equal to current height
            // For these popped elements, current index i is their right boundary
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }
          
            // The remaining top of stack (if exists) is the left boundary for current element
            left[i] = stack.isEmpty() ? -1 : stack.peek();
          
            // Push current index to stack
            stack.push(i);
        }
      
        // Calculate the maximum rectangle area for each bar as the minimum height
        for (int i = 0; i < n; i++) {
            // Width of rectangle with heights[i] as the minimum height
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
      
        return maxArea;
    }
}
