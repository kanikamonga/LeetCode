class Solution {
    public boolean isPalindrome(int x) {
        int revNo=0;
     if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        while(x>revNo){
            revNo = revNo*10+x%10;
            x=x/10;
      }
        return revNo==x  || x==revNo/10;
    }
}