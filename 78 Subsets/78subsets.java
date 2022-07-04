class Solution {
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        
        List<Integer> cur = new ArrayList<>();
        
        int n = nums.length;
        dfs(0,n,nums,cur);
        
        return res;
        
    }
    
    
    public void dfs(int start,int n,int[] nums,List<Integer> cur){
        res.add(new ArrayList<Integer>(cur));
        
        for(int i= start;i<n;i++){

            cur.add(nums[i]);
            dfs(i+1,n,nums,cur);
            cur.remove(cur.size()-1);
        }
        
    }
}