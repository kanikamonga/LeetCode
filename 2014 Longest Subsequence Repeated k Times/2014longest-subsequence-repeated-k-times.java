class Solution {
    private boolean isKRepeated(String s, String next, int k) {
        int repeatCount = 0, i = 0;
        for(int j=0; j<s.length(); j++) {
            if(next.charAt(i) == s.charAt(j)) {
                i++;
                if(i == next.length()) {
                    repeatCount++;
                    i = 0;

                    if(repeatCount == k) return true;
                }
            }
        }
        return false;
    }
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int seqLen = n / k;
        int[] count = new int[26];
        for(int i=0; i<n; i++)
            count[s.charAt(i) - 'a']++;

        List<Character> candidates = new ArrayList<>();
        for(char c = 'z'; c >= 'a'; c--){
            if(count[c-'a'] >= k)
                candidates.add(c);
        }

        Queue<String> q = new LinkedList<>();
        for(char c : candidates) {
            q.offer(String.valueOf(c));
        }

        String ans = "";
        while(!q.isEmpty()) {
            String cur = q.poll();
            if(cur.length() > ans.length())
                ans = cur;
            
            for(char c : candidates) {
                String next = cur + c;
                if(isKRepeated(s, next, k))
                    q.offer(next);
            }
        }

        return ans;
    }
}