class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
      
        // dp[i][j] represents whether substring s[i...j] is a palindrome
        boolean[][] dp = new boolean[n][n];
      
        // Initialize all single characters as palindromes (diagonal elements)
        for (boolean[] row : dp) {
            Arrays.fill(row, true);
        }
      
        // Variables to track the starting index and length of longest palindrome
        int startIndex = 0;
        int maxLength = 1;
      
        // Build the DP table bottom-up (from end to start of string)
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // Reset to false for substrings of length > 1
                dp[i][j] = false;
              
                // Check if current characters match
                if (s.charAt(i) == s.charAt(j)) {
                    // If characters match, check if inner substring is palindrome
                    // For substrings of length 2, dp[i+1][j-1] is true (single char or empty)
                    dp[i][j] = dp[i + 1][j - 1];
                  
                    // Update longest palindrome if current is longer
                    if (dp[i][j] && maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }
      
        // Return the longest palindromic substring
        return s.substring(startIndex, startIndex + maxLength);
    }
}