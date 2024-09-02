class Solution {
     List<String>  res=new  ArrayList<String>();
    public List<String> removeInvalidParentheses(String s) {
        return usingBFS(s);
    }

     List<String> usingBFS(String s){
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(s);
        visited.add(s);
        
        boolean found = false;
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            if (isValid(current)) {
                result.add(current);
                found = true;
            }
            
            if (found) continue; // no need to generate more substrings once we found valid ones
            
            // Generate new strings by removing one parenthesis at each position
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;
                
                String next = current.substring(0, i) + current.substring(i + 1);
                
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return result;
     }

     private boolean isValid(String s) {
        int count = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                if (count == 0) return false; // more ')' than '('
                count--;
            }
        }
        
        return count == 0;
    }
    
}