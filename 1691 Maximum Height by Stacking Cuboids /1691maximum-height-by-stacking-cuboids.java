class Solution {
    public int maxHeight(int[][] cuboids) {
        
       for(int[] dimensions: cuboids)
            Arrays.sort(dimensions); // sort each by height
        
        Arrays.sort(cuboids, (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
        
         int len = cuboids.length;
        int[] dp = new int[len];
        int max = 0;
        
        for(int i = 0; i < len; i++)
        {
            dp[i] = cuboids[i][2];
            for(int j = 0; j < i; j++)
            {
                if(cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2])
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
            }
            
            max = Math.max(max, dp[i]);
        }
        
        return max;

    }
}