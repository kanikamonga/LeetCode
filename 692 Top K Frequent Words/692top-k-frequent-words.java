class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Build frequency map: word -> count
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.merge(word, 1, Integer::sum);
        }
      
        // Sort words array based on:
        // 1. Frequency in descending order (higher frequency first)
        // 2. Lexicographical order for words with same frequency
        Arrays.sort(words, (word1, word2) -> {
            int frequency1 = frequencyMap.get(word1);
            int frequency2 = frequencyMap.get(word2);
          
            if (frequency1 == frequency2) {
                // Same frequency: sort lexicographically (ascending)
                return word1.compareTo(word2);
            } else {
                // Different frequency: sort by frequency (descending)
                return frequency2 - frequency1;
            }
        });
      
        // Collect top k unique words from sorted array
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length && result.size() < k; i++) {
            // Add word only if it's the first occurrence or different from previous
            if (i == 0 || !words[i].equals(words[i - 1])) {
                result.add(words[i]);
            }
        }
      
        return result;
    }
}
