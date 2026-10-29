class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0; // Initialize the count of subarrays
        // Initialize 'start' and 'end' as the current window's start and end indices,
        // and 'product' as the product of the elements within the window.
        for (int start = 0, end = 0, product = 1; end < nums.length; end++) {
            // Multiply the product by the current element.
            product *= nums[end];
            // While the product is not less than 'k' and 'start' is not beyond 'end'...
            while (start <= end && product >= k) {
                // ...divide the product by the 'start' element and move the start forward.
                product /= nums[start++];
            }
            // Add to count the number of subarray combinations with the current 'end'.
            // This is found by subtracting 'start' from 'end' and adding 1.
            count += end - start + 1;
        }
        // Return the total count of subarrays where the product is less than 'k'.
        return count;
    }
}
