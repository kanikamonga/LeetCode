class Solution {
    public int maxProfit(int[] prices) {
         int buy = prices[0],maxProfit = 0;
        
        
        for (int i=1;i<prices.length;i++){
            
            if(buy>prices[i]){
                buy = prices[i];
            }
            else if(prices[i] - buy>maxProfit) {
                maxProfit = prices[i] - buy;
            }              
            }
            
            
      

    return maxProfit;
    }
}