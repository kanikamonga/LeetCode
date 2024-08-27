class Solution {
    public int minTaps(int n, int[] ranges) {
       int[] maxReach = new int[n+1];
        
        for(int i=0;i<ranges.length;i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = i + ranges[i];   
            maxReach[start] = Math.max(maxReach[start], end); 
        }
        
        int tap = 0, currEnd = 0, nextEnd = 0;     
        for(int i=0;i<=n;i++) {
            //If i is beyond nextEnd, return -1 as a gap cannot be covered.
            if(i > nextEnd) return -1;
            if(i > currEnd) {
                tap++;
                currEnd = nextEnd;
            }
            
            nextEnd = Math.max(nextEnd, maxReach[i]);
        }
        return tap;
    }
}