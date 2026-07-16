class Solution {
     public int findSubstringInWraproundString(String p) {
        int n = p.length(), ans=0 ;
        char[] arr = p.toCharArray() ;
        int[] dp = new int[n] ;
        dp[0] = 1 ;
        for(int i=1; i<n; i++) {
            dp[i] = 1; 
            if((arr[i] == 'a' && arr[i-1] == 'z') || arr[i] - arr[i-1] == 1) 
                dp[i] += dp[i-1] ; 
        }
        int[] map = new int[26] ;
        for(int i=0; i<n; i++) {
            map[arr[i]-'a'] = Math.max(map[arr[i]-'a'], dp[i]) ;
        }
        for(int i : map) ans += i;
        return ans;
   }
}