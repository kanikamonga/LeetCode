class Solution {
    public String addBinary(String a, String b) {
        
        int p1 = a.length()-1;
        int p2 = b.length()-1;
        int carry=0;
        
        StringBuilder s = new StringBuilder();
        
        while(p1>=0||p2>=0){
            int x = p1>=0? a.charAt(p1--) - '0': 0;
            int y = p2>=0? b.charAt(p2--) - '0': 0;
            
            s.append((x+y+carry)%2);
            carry = (x+y+carry)/2;

        }
        
        if(carry>0) s.append(carry);
        return s.reverse().toString();
        
    }
}