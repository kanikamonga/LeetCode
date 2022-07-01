class Solution {
    public double myPow(double x, int n) {
        
        if(n<0){
            return 1/calc_pow(x,n);
        }
        return calc_pow(x,n);
        
        
    }
    
    
    public double calc_pow(double x, int n){
        
        if(n==0) return 1;
        
        double v = calc_pow(x,n/2);
        
        if(n%2==0) return v*v;
        else return v*v*x;
        
        
    }
}