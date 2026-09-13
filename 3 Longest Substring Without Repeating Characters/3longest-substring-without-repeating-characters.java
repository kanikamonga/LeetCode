class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Array to track character frequency in current window (ASCII characters)
        int[] charFrequency = new int[128];
      
        // Initialize variables
        int maxLength = 0;
        int stringLength = s.length();
        int left = 0;
      
        // Iterate through string with right pointer
        for (int right = 0; right < stringLength; right++) {
            // Get current character at right pointer
            char currentChar = s.charAt(right);
          
            // Increment frequency of current character
            charFrequency[currentChar]++;
          
            // Shrink window from left while we have duplicate characters
            while (charFrequency[currentChar] > 1) {
                // Decrement frequency of character at left pointer and move left pointer
                charFrequency[s.charAt(left)]--;
                left++;
            }
          
            // Update maximum length of substring without repeating characters
            maxLength = Math.max(maxLength, right - left + 1);
        }
      
        return maxLength;
    }
}
