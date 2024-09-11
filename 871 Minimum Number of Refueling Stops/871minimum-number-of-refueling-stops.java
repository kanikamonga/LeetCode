class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        if (startFuel>target) return 0;
        int maxDist = startFuel;
 PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0;
        int n = stations.length;
        int stops = 0;      
        while(maxDist<target){
            if(i<n && stations[i][0]<=maxDist){
                maxHeap.add(stations[i][1]);
                i++;
            } else if (maxHeap.isEmpty()) {
                return -1;
            } else{
                maxDist = maxHeap.poll() + maxDist;
                stops++;
            }

        }
                return stops;

    }
}