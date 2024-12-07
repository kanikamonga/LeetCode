class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());  
        return ans;
        
    }

    private void findCombinations(int index,int[] candidates, int target,List<List<Integer>> ans,List<Integer> pickList){

       
            if(target == 0 ){
                ans.add(new ArrayList<>(pickList));
                return;
            }

        for(int i = index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            pickList.add(candidates[i]);
            findCombinations(i+1,candidates,target-candidates[i],ans,pickList);  
            pickList.remove(pickList.size()-1);
        }
 
    }
}