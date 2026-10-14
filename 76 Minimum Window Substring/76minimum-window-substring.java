class Solution {
    public String minWindow(String s, String t) {
            Map<Character,Integer> map = new HashMap<>();

            int charFound=0;
            int end = 0;
            while(end<t.length()){
                map.put(t.charAt(end),map.getOrDefault(t.charAt(end),0) +1);
                end++;
            }

            end = 0;
            int start = 0,startIndex = -1,min = Integer.MAX_VALUE;

            while(end<s.length()){

                if(map.getOrDefault(s.charAt(end),0)>0){
                    charFound++;
                }
                                    map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0) - 1);


                while(charFound == t.length()){
                    int len = end-start+1;
                    if(len<min){
                        min = len;
                        startIndex = start;

                    }

                map.put(s.charAt(start),map.get(s.charAt(start))+1);
                if(map.get(s.charAt(start))>0) {
                    charFound--;
                }
                      start++;

                }
                end++;



            }

        return startIndex==-1? "" : s.substring(startIndex,startIndex+min);
 

    }
}