class Solution {
    public String largestGoodInteger(String num) {
        String ans = ""; 
        char max = Character.MIN_VALUE;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if(num.charAt(i)>max){
                ans = num.substring(i, i + 3); // Get substring of length 3
                max = num.charAt(i);
                }
            }
        }
        return ans;
    }
}