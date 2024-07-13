class Solution {
    public String decodeString(String s) {

        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> st1 = new Stack<>();

        int k = 0;

       for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k*10+Character.getNumericValue(c);
            } else if (c == '[') {
                stack.push(k);
                k = 0;
                st1.push(result);
                result = new StringBuilder();
            } else if (c == ']') {
                int size = stack.pop();
                StringBuilder temp = result;
                result = st1.pop();
                while (size-- > 0) {
                    result.append(temp);
                }
               
            } else {
                result.append(c);
            }
        }

        return result.toString();
        
    }
}