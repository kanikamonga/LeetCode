class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Get the lengths of both strings
        int length1 = text1.length();
        int length2 = text2.length();
      
        // Create a 2D DP table where dp[i][j] represents the length of LCS
        // for text1[0...i-1] and text2[0...j-1]
        int[][] dp = new int[length1 + 1][length2 + 1];
      
        // Fill the DP table
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // If characters match, extend the LCS from the diagonal cell
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum LCS from either
                    // excluding current character from text1 or text2
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
      
        // Return the LCS length for the entire strings
        return dp[length1][length2];
    }
}
