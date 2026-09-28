class Solution {
    public String reorganizeString(String s) {
        // Count frequency of each character
        int[] charFrequency = new int[26];
        int maxFrequency = 0;
      
        // Count occurrences and find maximum frequency
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            charFrequency[index]++;
            maxFrequency = Math.max(maxFrequency, charFrequency[index]);
        }
      
        // Check if reorganization is possible
        // If any character appears more than (n+1)/2 times, it's impossible
        int stringLength = s.length();
        if (maxFrequency > (stringLength + 1) / 2) {
            return "";
        }
      
        // Count number of unique characters
        int uniqueCharCount = 0;
        for (int frequency : charFrequency) {
            if (frequency > 0) {
                uniqueCharCount++;
            }
        }
      
        // Create array to store character frequencies and their indices
        int[][] charData = new int[uniqueCharCount][2];
        int dataIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (charFrequency[i] > 0) {
                charData[dataIndex][0] = charFrequency[i];  // frequency
                charData[dataIndex][1] = i;                  // character index
                dataIndex++;
            }
        }
      
        // Sort characters by frequency in descending order
        // This ensures most frequent characters are placed first
        Arrays.sort(charData, (a, b) -> b[0] - a[0]);
      
        // Build result string by placing characters at alternating positions
        StringBuilder result = new StringBuilder(s);
        int position = 0;
      
        // Place each character at alternating positions (0, 2, 4, ... then 1, 3, 5, ...)
        for (int[] charInfo : charData) {
            int frequency = charInfo[0];
            int charIndex = charInfo[1];
          
            while (frequency > 0) {
                result.setCharAt(position, (char) ('a' + charIndex));
                position += 2;  // Skip one position to ensure no adjacent duplicates
              
                // When even positions are filled, start filling odd positions
                if (position >= stringLength) {
                    position = 1;
                }
                frequency--;
            }
        }
      
        return result.toString();
    }
}
