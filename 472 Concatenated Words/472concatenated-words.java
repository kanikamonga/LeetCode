class Trie {
    // Array to store 26 child nodes (one for each lowercase letter a-z)
    Trie[] children = new Trie[26];
    // Flag to mark if current node represents the end of a word
    boolean isEndOfWord;

    /**
     * Inserts a word into the trie
     * @param word The word to be inserted
     */
    void insert(String word) {
        Trie currentNode = this;
      
        // Traverse through each character in the word
        for (char character : word.toCharArray()) {
            // Convert character to index (0-25)
            int index = character - 'a';
          
            // Create new node if path doesn't exist
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new Trie();
            }
          
            // Move to the child node
            currentNode = currentNode.children[index];
        }
      
        // Mark the last node as end of word
        currentNode.isEndOfWord = true;
    }
}

/**
 * Solution class to find all concatenated words in a dictionary
 * A concatenated word is formed by combining two or more shorter words from the dictionary
 */
class Solution {
    // Trie to store all words for efficient prefix matching
    private Trie trie = new Trie();

    /**
     * Finds all concatenated words in the given array
     * @param words Array of words to check
     * @return List of concatenated words
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // Sort words by length to ensure shorter words are processed first
        Arrays.sort(words, (word1, word2) -> word1.length() - word2.length());
      
        List<String> concatenatedWords = new ArrayList<>();
      
        // Process each word
        for (String word : words) {
            // Check if current word can be formed by concatenating existing words in trie
            if (canFormByConcatenation(word)) {
                concatenatedWords.add(word);
            } else {
                // If not a concatenated word, add it to trie for future use
                trie.insert(word);
            }
        }
      
        return concatenatedWords;
    }

    /**
     * Checks if a word can be formed by concatenating other words in the trie
     * Uses DFS to explore all possible word combinations
     * @param word The word to check
     * @return true if word can be formed by concatenation, false otherwise
     */
    private boolean canFormByConcatenation(String word) {
        // Base case: empty string means we've successfully matched all parts
        if ("".equals(word)) {
            return true;
        }
      
        Trie currentNode = trie;
      
        // Try to match prefixes of the word
        for (int i = 0; i < word.length(); ++i) {
            int charIndex = word.charAt(i) - 'a';
          
            // If no path exists for current character, word cannot be formed
            if (currentNode.children[charIndex] == null) {
                return false;
            }
          
            // Move to next node
            currentNode = currentNode.children[charIndex];
          
            // If current position marks end of a word, try to match remaining part
            if (currentNode.isEndOfWord && canFormByConcatenation(word.substring(i + 1))) {
                return true;
            }
        }
      
        // No valid concatenation found
        return false;
    }
}
