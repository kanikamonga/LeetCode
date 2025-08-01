class Solution {
    public List<List<Integer>> generate(int numRows) {
        int a = 1;
        List<List<Integer>> res = new ArrayList<>(); 
        for(int i=0;i<numRows;i++){
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            if(i>0){
                List<Integer> prev = res.get(i-1);
            for(int j = 1;j<i;j++){
                cur.add(prev.get(j) + prev.get(j-1));
            }
            cur.add(1);
            }
            res.add(cur);
        }
        return res;
    }
}