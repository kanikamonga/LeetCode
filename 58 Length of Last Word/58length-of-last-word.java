class Solution {
   public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int p = s.length()-1;
        while(p >=0 && s.charAt(p) == ' ') p--;
        if(p < 0) return 0;
        int res = 0;
        while( p >=0 && s.charAt(p) != ' '){
            p--;
            res++;
        }
        return res;
    }
}