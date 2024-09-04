class Solution {
    public boolean isMatch(String s, String p) {
         int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

         // Initialization - Case 1: Both string and pattern are empty
        dp[0][0] = true;
        // Initialization - Case 2: Pattern is empty, but string is not
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        // Initialization - Case 3: String is empty, but pattern is not
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // Case 1: Characters match or pattern has '?'
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // Case 2: Pattern has '*'
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                // Case 3: Characters do not match
                 else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
 
    }
}