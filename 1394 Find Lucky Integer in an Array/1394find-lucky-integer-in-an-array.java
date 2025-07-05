class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int a :arr) {
            map.put(a,map.getOrDefault(a,0)+1);
        }

        int max = -1;
        for(Integer k : map.keySet()){
            if(map.get(k) == k){
                max = Math.max(k,max);
            }
        }

        return max;

    }
}