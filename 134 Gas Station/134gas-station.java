class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     
        int curr = 0;
        int tank = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
           curr += gas[i] - cost[i]; 
           tank += gas[i]-cost[i];
            if(curr<0){
                curr = 0;
                start = i+1;
            }
            
        }
        
        if(tank>=0){
            return start;
        }
        
        return -1;
        
    }
}