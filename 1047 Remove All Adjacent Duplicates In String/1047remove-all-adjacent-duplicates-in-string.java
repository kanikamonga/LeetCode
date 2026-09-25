class Solution {
    /**
     * Removes all adjacent duplicate characters from the string.
     * When two adjacent characters are the same, both are removed.
     * This process continues until no adjacent duplicates remain.
     * 
     * @param s the input string to process
     * @return the string after removing all adjacent duplicates
     */
    public String removeDuplicates(String s) {
        // Use StringBuilder as a stack to build the result
        StringBuilder resultBuilder = new StringBuilder();
      
        // Process each character in the input string
        for (char currentChar : s.toCharArray()) {
            // Check if the last character in result matches current character
            if (resultBuilder.length() > 0 && 
                resultBuilder.charAt(resultBuilder.length() - 1) == currentChar) {
                // // Remove the last character (pop from stack)
                resultBuilder.deleteCharAt(resultBuilder.length() - 1);
            } else {
                // Add current character to result (push to stack)
                resultBuilder.append(currentChar);
            }
        }
      
        // Convert StringBuilder to String and return
        return resultBuilder.toString();
    }
}
