class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int left = 0, right = 0, n = nums.length;

        while(right < n) {
            map.put(nums[right], 1 + map.getOrDefault(nums[right], 0));
            int min = map.firstKey(), max = map.lastKey();

            while(max - min > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;

                min = map.firstKey();
                max = map.lastKey();
            }

            ans += right - left + 1;

            right++;
        }

        return ans;
    }
}