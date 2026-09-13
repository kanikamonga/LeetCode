class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int waysToReachStair(int k) {

        return rec(1, 0, 0, k);  // stair, jump, backJump, k
    }
    int rec(int stair, int jump, int backJump, int k){

        //caching
        String key = (stair+""+jump+""+backJump);
        if(map.containsKey(key)) return map.get(key);

        int ans = 0;
        //prunning
        if(stair==k) ans++;     // don't return we have to check for every possible way

        //transition
        if(stair != 0 && backJump != 1){
            ans += rec(stair-1, jump, 1, k);
        }

        int nextStair = stair + (1<<jump);      // i + 2jump
        if(nextStair <= k+1){
            ans += rec(nextStair, jump+1, 0, k);
        }

        map.put(key, ans);
        return ans;
    }
}

// TC= k*32*2