class Solution {
    public int characterReplacement(String s, int k) {
          
        int start=0;
        int end =0;
        int max = 0;
        
        int maxCount = 0;
        
        Map<Character,Integer> map = new HashMap<>();        
        
        for(end =0;end<s.length();end++){
            Character c = s.charAt(end);
        
            int count = map.getOrDefault(c,0)+1;
            maxCount =Math.max(count,maxCount); 
            map.put(c,count);
            
            if(end-start+1 - maxCount > k){
                Character c1 = (Character)s.charAt(start);
                map.put(c1,map.getOrDefault(c1,0)-1);
                start++;
            }else
        max = Math.max(max,end-start+1);        

        }
    return max;
    }
}