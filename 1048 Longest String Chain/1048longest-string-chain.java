class Solution {
    public int longestStrChain(String[] words) {
        // Sort words by length in ascending order
        Arrays.sort(words, Comparator.comparingInt(String::length));
      
        // Variable to track the maximum chain length found
        int maxChainLength = 0;
      
        // Map to store each word and its longest chain length ending at that word
        Map<String, Integer> wordToChainLength = new HashMap<>();
      
        // Process each word in order of increasing length
        for (String currentWord : words) {
            // Initialize the chain length for current word as 1 (the word itself)
            int currentChainLength = 1;
          
            // Try removing each character to find potential predecessors
            for (int i = 0; i < currentWord.length(); ++i) {
                // Create predecessor by removing character at position i
                String predecessor = currentWord.substring(0, i) + currentWord.substring(i + 1);
              
                // Update chain length if this predecessor exists and gives a longer chain
                currentChainLength = Math.max(currentChainLength, 
                                             wordToChainLength.getOrDefault(predecessor, 0) + 1);
            }
          
            // Store the longest chain length ending at current word
            wordToChainLength.put(currentWord, currentChainLength);
          
            // Update the global maximum chain length
            maxChainLength = Math.max(maxChainLength, currentChainLength);
        }
      
        return maxChainLength;
    }
}
