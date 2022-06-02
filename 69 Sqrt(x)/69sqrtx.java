class Solution {
    public int mySqrt(int x) {
     
        int start =0, mid = 0,end = x;

        int ans =0;
        
        if(x==0||x==1)
            return x;
        
        while(start<=end){
            mid = (start+end)/2;
            
            if(mid == x/mid){
                return mid;
            }
            
            if(mid > x/mid)
             end = mid-1;
            else {
                start = mid+1;
                ans = mid;
                
            }
            
        }
      
        return ans;
        
    }
}