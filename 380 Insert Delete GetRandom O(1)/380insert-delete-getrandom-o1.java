class RandomizedSet {
    // HashMap to store value -> index mapping for O(1) lookup
    private Map<Integer, Integer> valueToIndexMap;
    // ArrayList to store actual values for O(1) random access
    private List<Integer> valuesList;
    // Random number generator for getRandom() method
    private Random random;

    /**
     * Initialize the RandomizedSet data structure
     */
    public RandomizedSet() {
        valueToIndexMap = new HashMap<>();
        valuesList = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set
     * @param val - value to insert
     * @return true if the set did not already contain the specified element
     */
    public boolean insert(int val) {
        // Check if value already exists
        if (valueToIndexMap.containsKey(val)) {
            return false;
        }
      
        // Add value to the end of the list and store its index in the map
        valueToIndexMap.put(val, valuesList.size());
        valuesList.add(val);
        return true;
    }

    /**
     * Removes a value from the set
     * @param val - value to remove
     * @return true if the set contained the specified element
     */
    public boolean remove(int val) {
        // Check if value exists
        if (!valueToIndexMap.containsKey(val)) {
            return false;
        }
      
        // Get the index of the value to be removed
        int indexToRemove = valueToIndexMap.get(val);
        int lastElement = valuesList.get(valuesList.size() - 1);
      
        // Move the last element to the position of the element to be removed
        valuesList.set(indexToRemove, lastElement);
        // Update the index of the moved element in the map
        valueToIndexMap.put(lastElement, indexToRemove);
      
        // Remove the last element from the list
        valuesList.remove(valuesList.size() - 1);
        // Remove the value from the map
        valueToIndexMap.remove(val);
      
        return true;
    }

    /**
     * Get a random element from the set
     * @return a random element from the set
     */
    public int getRandom() {
        return valuesList.get(random.nextInt(valuesList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
