class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int j = 0;
        int count = 0;
        int i=0;
         int m = players.length;
        int n = trainers.length;
        while(i<m && j<n){
            if(players[i]<=trainers[j]){
                j++;
                i++;
                count++;
            } else{
            j++;

            }
        }
        return count;

    }
}