class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        
        Stack<String> stack = new Stack<>();
        for(String p: paths){
            if(!p.isEmpty() && !p.equals(".") && !p.equals("..")){
                stack.push(p);
            }else if (!stack.isEmpty() && p.equals("..")){
                stack.pop();
            }
        }
    
        StringBuilder res = new StringBuilder();
        
        for(String s:stack){
            res.append("/").append(s);
        }
        
        return res.isEmpty()?"/":res.toString();
    }
}