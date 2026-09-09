class Solution {
    public int calculate(String s) {
        // Stack to store intermediate results
        Deque<Integer> stack = new ArrayDeque<>();
      
        // Current operator, initialized to '+'
        char operator = '+';
      
        // Current number being parsed
        int currentNumber = 0;
      
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
          
            // Build multi-digit numbers
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
          
            // Process the number when we encounter an operator or reach the end
            // Skip spaces by checking if it's an operator or end of string
            if (i == s.length() - 1 || 
                currentChar == '+' || 
                currentChar == '-' || 
                currentChar == '*' || 
                currentChar == '/') {
              
                // Apply the previous operator to the current number
                if (operator == '+') {
                    stack.push(currentNumber);
                } else if (operator == '-') {
                    stack.push(-currentNumber);
                } else if (operator == '*') {
                    // Pop the last number and multiply with current number
                    stack.push(stack.pop() * currentNumber);
                } else if (operator == '/') {
                    // Pop the last number and divide by current number
                    stack.push(stack.pop() / currentNumber);
                }
              
                // Update operator for next iteration
                operator = currentChar;
              
                // Reset current number for next parsing
                currentNumber = 0;
            }
        }
      
        // Sum all numbers in the stack to get the final result
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
      
        return result;
    }
}
