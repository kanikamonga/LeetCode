class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
       if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        while (!map.isEmpty()) {
            int key = map.firstKey();
            for (int i = key; i < key + k; i++) {
                if (!map.containsKey(i)) return false;
                int value = map.get(i);
                if (value == 1)  map.remove(i);
                else map.put(i, value - 1);
            }
        }
        return true;
    }
}