class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> stack = new Stack<>();
        
        
        for(int i=0;i<tokens.length;i++){
            
            if("+-*/".contains(tokens[i])){
                if(!stack.isEmpty()){
                    Integer y = Integer.valueOf(stack.pop());
                    Integer x = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(calculate(x,y,tokens[i])));
                }
                
            }else{
                stack.push(tokens[i]);
            }
            
        }
        
        return Integer.valueOf(stack.pop());
    }
    
    
   private Integer calculate(Integer x,Integer y,String op){
       
       if("+".equals(op)) return x+y;
       if("-".equals(op)) return x-y;
       if("*".equals(op)) return x*y;
       if("/".equals(op)) return x/y;
       
       return -1;
   }
}