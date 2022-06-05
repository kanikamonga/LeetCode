class Solution {
    public boolean checkRecord(String s) {
        
        int a = 0,l=0,p=0;
        
        
        for(int i=0;i<s.length();i++){
            while(i<s.length() && s.charAt(i) == 'L'){
                    l++;
                    i++;                    
              }
            
            if(l>2)
                return false;
            else {
                l = 0;
            }
            
           if(i<s.length() && s.charAt(i) == 'A')
                a++;
            if(a>1) return false;
            
           
        }
        
        if(a<2&&l<3)
            return true;
        
        
        return false;
        
        
        
    }
}