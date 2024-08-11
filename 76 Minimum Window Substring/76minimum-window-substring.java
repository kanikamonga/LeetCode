class Solution {
    public String minWindow(String s, String t) {
         int start=0,end=0,minLen=Integer.MAX_VALUE,charFound=0,startIndex=-1;
        Map<Character,Integer> map = new HashMap();
        while(end<t.length())
        {
            map.put(t.charAt(end),map.getOrDefault(t.charAt(end),0)+1);
            end++;
        }
        end=0;
        //Start the window
        while(end<s.length())
        {
            if(map.getOrDefault(s.charAt(end),0) > 0){
             charFound++;
            }
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)-1);

            while(charFound==t.length())
            {
                if(end-start+1<minLen)
                {
                    minLen = end-start+1;
                    startIndex=start;
                }
                //Move the window
                map.put(s.charAt(start),map.get(s.charAt(start))+1);
                if(map.get(s.charAt(start))>0) {
                    charFound--;
                }
                start++;
            }
            end++;
        }

        return startIndex==-1? "" : s.substring(startIndex,startIndex+minLen);
    }
    
}