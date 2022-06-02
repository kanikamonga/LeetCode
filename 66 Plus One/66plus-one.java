class Solution {
    public int[] plusOne(int[] digits) {
        
        int n= digits.length-1;
        while(n>=0 && digits[n]==9){
            digits[n]=0;
            n--;
        }

        if(n<0){
          int[] arr = new int[digits.length+1];
            Arrays.fill(arr,0);
            arr[0] = 1;
            return arr;
         }
        else{
        digits[n] = digits[n]+1;            
        }
        return digits;
        }
                
    }
