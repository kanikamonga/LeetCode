class Solution {
    /**
     * Counts the number of palindromic substrings in the given string.
     * Uses the expand-around-center approach to find all palindromes.
     * 
     * @param s the input string
     * @return the total count of palindromic substrings
     */
    public int countSubstrings(String s) {
        int palindromeCount = 0;
        int stringLength = s.length();
      
        // Iterate through all possible palindrome centers (2n-1 total)
        // Centers include both characters (n) and gaps between characters (n-1)
        for (int centerIndex = 0; centerIndex < stringLength * 2 - 1; centerIndex++) {
            // Calculate left and right pointers based on center index
            // For even centerIndex: both pointers start at centerIndex/2 (odd-length palindrome)
            // For odd centerIndex: pointers start at adjacent positions (even-length palindrome)
            int leftPointer = centerIndex / 2;
            int rightPointer = (centerIndex + 1) / 2;
          
            // Expand around the center while characters match
            while (leftPointer >= 0 && rightPointer < stringLength && 
                   s.charAt(leftPointer) == s.charAt(rightPointer)) {
                // Found a palindrome, increment counter
                palindromeCount++;
              
                // Expand outward from center
                leftPointer--;
                rightPointer++;
            }
        }
      
        return palindromeCount;
    }
}
