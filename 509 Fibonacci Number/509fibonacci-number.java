class Solution {
    public int fib(int n) {
       int first = 0;
       int second = 1;
        if(n==0) return first;
        if(n==1) return second;
         int cur = first+second;
        for(int i=2;i<=n;i++){
            cur = first+second;
            first = second;
            second = cur;
        }

        return cur; 


    }
}