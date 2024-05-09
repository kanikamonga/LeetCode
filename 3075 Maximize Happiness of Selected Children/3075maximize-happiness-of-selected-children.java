class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        Arrays.sort(happiness);
        long sum = 0;
        int len = happiness.length-1;

        for(int i=0;i<k;i++){
            int val = happiness[len-i]-i;
            if(val<0) val = 0;
            sum+= val;
        }
        return sum;
    }
}