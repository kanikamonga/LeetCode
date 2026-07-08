class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
      
        // dp[i][j] represents the length of LCS (Longest Common Subsequence) 
        // of str1[0...i-1] and str2[0...j-1]
        int[][] dp = new int[len1 + 1][len2 + 1];
      
        // Build the LCS table using dynamic programming
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // Characters match, extend the LCS
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Characters don't match, take the maximum LCS from previous states
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
      
        // Reconstruct the shortest common supersequence by backtracking through the DP table
        int i = len1;
        int j = len2;
        StringBuilder result = new StringBuilder();
      
        while (i > 0 || j > 0) {
            if (i == 0) {
                // Reached the end of str1, append remaining characters from str2
                result.append(str2.charAt(--j));
            } else if (j == 0) {
                // Reached the end of str2, append remaining characters from str1
                result.append(str1.charAt(--i));
            } else {
                // Check where the current LCS value came from
                if (dp[i][j] == dp[i - 1][j]) {
                    // LCS value came from top cell, character from str1 is not in LCS
                    result.append(str1.charAt(--i));
                } else if (dp[i][j] == dp[i][j - 1]) {
                    // LCS value came from left cell, character from str2 is not in LCS
                    result.append(str2.charAt(--j));
                } else {
                    // Characters match and are part of LCS, add once and move both pointers
                    result.append(str1.charAt(--i));
                    j--;
                }
            }
        }
      
        // Reverse the result since we built it backwards
        return result.reverse().toString();
    }
}
