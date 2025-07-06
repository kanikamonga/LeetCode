class FindSumPairs {

    int []p,q;
    Map<Integer,Integer> m1 =  new HashMap<>();
    Map<Integer,Integer> m2 =  new HashMap<>();
        

    public FindSumPairs(int[] nums1, int[] nums2) {
        p = nums1;
        q = nums2;
        
        for(int a:nums1){
            m1.put(a,m1.getOrDefault(a,0) + 1);
        }
        for(int a:nums2){
            m2.put(a,m2.getOrDefault(a,0)+ 1);
        }


    }
    
    public void add(int index, int val) {
        m2.put(q[index],m2.get(q[index])-1);
        q[index]+=val;
        m2.put(q[index],m2.getOrDefault(q[index],0)+1);
    }
    
    public int count(int tot) {
        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            int val = entry.getKey();
            int freq = entry.getValue();
            int remain = tot - val;
            pairs += freq * m2.getOrDefault(remain, 0);
        }

       return pairs;
        
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */