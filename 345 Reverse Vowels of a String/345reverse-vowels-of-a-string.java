class Solution {
    public String reverseVowels(String s) {
        int i=0,j= s.length()-1;
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        while(i<j){
          if(checkVowel(s.charAt(i)) && checkVowel(s.charAt(j))){
                char temp = s.charAt(i);
                sb.setCharAt(i,s.charAt(j));
                sb.setCharAt(j,temp);
                i++;
                j--;
              
          } else  if(checkVowel(s.charAt(i))){
                j--;
            }
            
           else if(checkVowel(s.charAt(j))){
                i++;
            }
               
             else{
              i++;j--;
          }
        }
        
    
        return sb.toString();
    }
    
    private boolean checkVowel(char ch){
       return (ch == 'a' ||ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' ||ch == 'A' || ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U');
          
    }
}