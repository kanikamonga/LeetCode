class Solution {
    public char kthCharacter(int k) {

        StringBuilder s = new StringBuilder("a");

        while(s.length()<k){
            String str = s.toString();
            for(char c:str.toCharArray()){
                if(c=='z')
                s.append("a");
                else s.append(String.valueOf( (char) (c + 1)));
            }
        }
        System.out.print(s);
        return s.charAt(k-1);

        
    }
}