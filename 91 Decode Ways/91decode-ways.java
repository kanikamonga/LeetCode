class Solution {
    public int numDecodings(String s) {
        int length = s.length();
      
        // dp[i] represents the number of ways to decode substring s[0...i-1]
        int[] dp = new int[length + 1];
      
        // Base case: empty string has one way to decode
        dp[0] = 1;
      
        // Iterate through each position in the string
        for (int i = 1; i <= length; i++) {
            // Single digit decoding: check if current digit is valid (1-9)
            if (s.charAt(i - 1) != '0') {
                // If valid, inherit the count from previous position
                dp[i] = dp[i - 1];
            }
          
            // Two digit decoding: check if previous two digits form a valid number (10-26)
            if (i > 1 && s.charAt(i - 2) != '0') {
                int twoDigitNumber = Integer.valueOf(s.substring(i - 2, i));
                if (twoDigitNumber <= 26) {
                    // Add the count from two positions back
                    dp[i] += dp[i - 2];
                }
            }
        }
      
        // Return the total number of ways to decode the entire string
        return dp[length];
    }
}
