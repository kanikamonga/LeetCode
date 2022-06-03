class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character,Character> map = new HashMap<>();
        Set<Character> assigned = new HashSet<>();
        
        for (int i=0;i<s.length();i++){
            
           
            if(!map.containsKey(s.charAt(i)) && !assigned.contains(t.charAt(i))){
                map.put(s.charAt(i),t.charAt(i));
                assigned.add(t.charAt(i));
            }else if(!map.containsKey(s.charAt(i)) && assigned.contains(t.charAt(i))){
               return false;
            }
            else if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }

            
        }
        return true;
    }
}