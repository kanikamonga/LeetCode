class Solution {
   public List<String> res = new ArrayList<>();
    public  Map<Integer,String> map = new HashMap<>();
   
    public List<String> letterCombinations(String digits) {
        
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        
        backTrack("",0,digits);
        return res;
        
    }
    
    
    public void backTrack(String result,int k,String digits){

        if(k==digits.length()){
            if(!result.isEmpty()) res.add(result);
            return;
        }

        String s = map.get(digits.charAt(k) - '0');
        
        for(Character c : s.toCharArray()){
             backTrack(result+c,k+1,digits);
        }
        
        
    }
    
}