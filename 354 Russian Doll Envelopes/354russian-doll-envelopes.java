class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 
       || envelopes[0] == null || envelopes[0].length != 2)
        return 0;
    Arrays.sort(envelopes, new Comparator<int[]>(){
        public int compare(int[] arr1, int[] arr2){
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
       } 
    });

// for(int[] envelope : envelopes){
//      System.out.println(envelope[0] + " "+envelope[1]);
// }

    int dp[] = new int[envelopes.length];
    int len = 0;
    for(int[] envelope : envelopes){
        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
         System.out.println(index);
        if(index < 0)
            index = -(index + 1);
        dp[index] = envelope[1];
         System.out.println(index + " "+dp[index]);
        if(index == len)
            len++;
    }
    return len;
    }
}