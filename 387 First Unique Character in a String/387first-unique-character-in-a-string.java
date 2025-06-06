class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(Character.valueOf(c),map.getOrDefault(Character.valueOf(c),0) + 1);
        }

        for(int i = 0;i<s.length();i++){
            if(map.get(Character.valueOf(s.charAt(i)))==1){
                return i;
            }
        }      

        return -1;
    }
}