class Solution {
    /**
     * Removes consecutive characters that appear three or more times in a row,
     * keeping at most two consecutive occurrences of any character.
     * 
     * @param s the input string to process
     * @return a fancy string with no three consecutive identical characters
     */
    public String makeFancyString(String s) {
        // Use StringBuilder for efficient string concatenation
        StringBuilder result = new StringBuilder();
      
        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
          
            // Add the character if:
            // 1. It's one of the first two characters (i < 2), OR
            // 2. It's different from the previous character, OR
            // 3. It's different from the character two positions back
            // This ensures no three consecutive identical characters
            if (i < 2 || currentChar != s.charAt(i - 1) || currentChar != s.charAt(i - 2)) {
                result.append(currentChar);
            }
        }
      
        // Convert StringBuilder to String and return
        return result.toString();
    }
}
