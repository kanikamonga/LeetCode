class Solution {
   public int minimumDistance(String word) {
        HashMap<String,Integer> cache= new HashMap<>();
        return type(word,'\0', '\0',0,cache);
    }


    int type(String word,char leftFinger,char rightFinger,int i,HashMap<String,Integer> cache){
        if(i>=word.length())return 0;

        String key=leftFinger+" "+rightFinger+" "+i;
        if(cache.containsKey(key))return cache.get(key);

        int left=distance(leftFinger,word.charAt(i))+type(word,word.charAt(i),rightFinger,i+1,cache);

        int right=distance(rightFinger,word.charAt(i))+type(word,leftFinger,word.charAt(i),i+1,cache);
        cache.put(key,Math.min(left,right));
        return Math.min(left,right);
    }

    int distance(char prev,char curr){

        if(prev=='\0')return 0;
        int x1=(prev-'A')/6;
        int x2=(curr-'A')/6;
        int y1=(prev-'A')%6;
        int y2=(curr-'A')%6;

         return Math.abs(x2-x1)+Math.abs(y2-y1);
    }
}