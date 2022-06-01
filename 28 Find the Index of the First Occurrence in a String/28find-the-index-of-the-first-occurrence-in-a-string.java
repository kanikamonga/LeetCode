class Solution {
    public int strStr(String haystack, String needle) {
        
       int start=0;int end=needle.length();
        
        
        for(int i =0;i<=haystack.length()-end;i++){
            int windowEnd = 0;
            start=0;
            while(start<end && haystack.charAt(i+start) == needle.charAt(start)){
                    start++;
                windowEnd++;
            }
            
            if(windowEnd == end){
                return i;
            }
            
                   
        }
        return -1;
    }
}