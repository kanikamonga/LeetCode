class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String ans = countAndSay(n-1);

        int count = 0;
        StringBuilder r = new StringBuilder();
        for(int i=0;i<ans.length();i++){
            count++;
            
            if(i == ans.length()-1 || ans.charAt(i)!=ans.charAt(i+1)){
                r.append(count).append(ans.charAt(i));
                count = 0;
            }
            
        }
        return r.toString();
        
    }
    
}