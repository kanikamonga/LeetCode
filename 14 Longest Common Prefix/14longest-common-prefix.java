class Solution {
    /**
     * Finds the longest common prefix string amongst an array of strings.
     *
     * @param strs Array of strings to find common prefix from
     * @return The longest common prefix, or empty string if no common prefix exists
     */
    public String longestCommonPrefix(String[] strs) {
        // Get the total number of strings in the array
        int numberOfStrings = strs.length;

        // Iterate through each character position of the first string
        for (int charIndex = 0; charIndex < strs[0].length(); charIndex++) {
            // Compare this character position across all other strings
            for (int stringIndex = 1; stringIndex < numberOfStrings; stringIndex++) {
                // Check if current string is shorter than current position
                // or if character at current position doesn't match first string
                if (strs[stringIndex].length() <= charIndex ||
                    strs[stringIndex].charAt(charIndex) != strs[0].charAt(charIndex)) {
                    // Return the common prefix found so far
                    return strs[0].substring(0, charIndex);
                }
            }
        }

        // If we've checked all characters of first string without mismatch,
        // the entire first string is the common prefix
        return strs[0];
    }
}
