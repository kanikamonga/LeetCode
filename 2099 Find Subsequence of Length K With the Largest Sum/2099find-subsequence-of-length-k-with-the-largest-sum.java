class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
     int n;
    n = nums.length;
    //Storing value and idx
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    for(int i = 0; i < n; i++){
        if(pq.size() < k){
            pq.offer(new int[]{i, nums[i]});
        } 
        else if(nums[i] > pq.peek()[1]){
            pq.poll();
            pq.offer(new int[]{i, nums[i]});
        }
    }
    ArrayList<int[]> topK = new ArrayList<>(pq);
    Collections.sort(topK, (a, b) -> a[0] - b[0]);
    int[] resultant = new int[k];
    for(int i = 0; i < k; i++){
        resultant[i] = topK.get(i)[1];
    }
    return resultant;
   
    }
}