class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        Integer longest = 0;
        Integer cntr = 0;


        for(int o: nums) {
            set.add(o);
        }

        for(Integer n: set) {
            if (hasPrevious(n, set)) continue;
            else longest = Math.max(checkLongestSequence(n, set), longest);
        }

        return longest;
    }

    private boolean hasPrevious(Integer n, Set set) {
        return set.contains(n - 1);
    }

    private Integer checkLongestSequence(Integer n, Set set) {
        Integer cnt = 0;
        while(set.contains(n++)) {
            cnt++;
        }
        return cnt;
    }
}