class Solution {
    public String intToRoman(int num) {
        String nums[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] n = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder result = new StringBuilder();
        for(int i=0;i<n.length;i++){
            
            while(num>=n[i]){
                result.append(nums[i]);
                num = num - n[i];
            }
            
        }
     return result.toString();   
    }
}