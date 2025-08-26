class Solution {
    public int maxScore(int[] card, int k) {
        int n = card.length;
        int lsum = 0;
        for (int i = 0; i < k; i++) {
            lsum += card[i];
        }
        
        int max = lsum;
        int rsum = 0;
        int r = n - 1;
        for (int i = k - 1; i >= 0; i--,r--) {
            lsum -= card[i];     
            rsum += card[r];   
            max = Math.max(max, lsum + rsum);
        }
        
        return max;
    }
}