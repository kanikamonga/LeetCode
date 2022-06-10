class Solution {
    public int myAtoi(String s) {
        
        int x = 0;
        int neg =1;
        int n = s.length();
        

        int i=0;
        while(i<n && s.charAt(i) == ' ') i++;
        
        if(i<n&&s.charAt(i) == '+') i++;

       else if(i<n&&s.charAt(i) == '-') {
            i++;
            neg = -1;
        }
        
        while(i<n){
            if(Character.isDigit(s.charAt(i))){
                int d = s.charAt(i) - '0';
                
                if(x>Integer.MAX_VALUE/10||(x==Integer.MAX_VALUE/10 && d>Integer.MAX_VALUE%10)) return neg == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                x = 10*x+d;
                i++;
                
                
            }else break;
        }
    return x*neg;
    }
}