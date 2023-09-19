class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //Greedy
         int totalCost = 0;
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int costLength = costs.length;
        
        for (int i = 0; i < costLength / 2; i++) {
            totalCost += costs[i][0] + costs[costLength - i - 1][1];
        }
        
        return totalCost;
    }
}