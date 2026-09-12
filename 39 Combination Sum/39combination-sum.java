class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> sum = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        bt_dfs(candidates,target,0);

        return result;

    }


    public void bt_dfs(int[] arr, int target, int startIndex){

        if(target == 0){
             result.add(new ArrayList<>(sum));
            return;
        }

        if(target< arr[startIndex]){
            return;
        }

        for(int i=startIndex;i<arr.length;i++){
            sum.add(arr[i]);
            bt_dfs(arr,target-arr[i],i);
            sum.remove(sum.size()-1);
        }
    }
}