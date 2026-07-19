class Trie {
    // Array to store 26 child nodes (for lowercase letters a-z)
    private Trie[] children;
    // Flag to mark if current node represents end of a word
    private boolean isEndOfWord;
  
    /**
     * Constructor initializes the Trie node
     */
    public Trie() {
        this.children = new Trie[26];
        this.isEndOfWord = false;
    }
  
    /**
     * Inserts a word into the Trie
     * @param word The word to be inserted
     */
    public void insert(String word) {
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
      
        // Mark the end of the word
        currentNode.isEndOfWord = true;
    }
  
    /**
     * Searches for a complete word in the Trie
     * @param word The word to search for
     * @return true if the word exists in the Trie, false otherwise
     */
    public boolean search(String word) {
        Trie currentNode = this;
      
        // Traverse through each character in the word
        for (char character : word.toCharArray()) {
            // Convert character to index (0-25)
            int index = character - 'a';
          
            // Return false if path doesn't exist
            if (currentNode.children[index] == null) {
                return false;
            }
          
            // Move to the child node
            currentNode = currentNode.children[index];
        }
      
        // Check if current node marks the end of a word
        return currentNode.isEndOfWord;
    }
}

/**
 * Solution class for Word Break II problem
 * Given a string and a dictionary of words, returns all possible sentences
 * that can be formed by breaking the string using dictionary words
 */
class Solution {
    private Trie trie;
  
    /**
     * Main method to break the string into valid sentences using dictionary words
     * @param s The input string to break
     * @param wordDict List of valid dictionary words
     * @return List of all possible valid sentences
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Initialize Trie and insert all dictionary words
        trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }
      
        // Get all possible word combinations using DFS
        List<List<String>> wordCombinations = dfs(s);
      
        // Convert list of word lists to list of sentences (space-separated)
        return wordCombinations.stream()
                .map(words -> String.join(" ", words))
                .collect(Collectors.toList());
    }
  
    /**
     * Recursive DFS helper method to find all valid word combinations
     * @param remainingString The remaining substring to process
     * @return List of all possible word combinations for the remaining string
     */
    private List<List<String>> dfs(String remainingString) {
        List<List<String>> result = new ArrayList<>();
      
        // Base case: empty string means we've successfully broken the entire string
        if (remainingString.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }
      
        // Try all possible prefixes starting from index 1
        for (int endIndex = 1; endIndex <= remainingString.length(); endIndex++) {
            String prefix = remainingString.substring(0, endIndex);
          
            // If prefix exists in dictionary, recursively process the remaining string
            if (trie.search(prefix)) {
                String suffix = remainingString.substring(endIndex);
                List<List<String>> suffixCombinations = dfs(suffix);
              
                // Add current prefix to each valid combination from suffix
                for (List<String> combination : suffixCombinations) {
                    // Insert prefix at the beginning of the combination
                    combination.add(0, prefix);
                    result.add(combination);
                }
            }
        }
      
        return result;
    }
}
