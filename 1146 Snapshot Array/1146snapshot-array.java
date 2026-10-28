class SnapshotArray {
    // Array of lists, where each list stores [snapId, value] pairs for each index
    private List<int[]>[] snapshotHistory;
    // Current snapshot ID counter
    private int currentSnapId;

    /**
     * Initialize the snapshot array with the given length
     * @param length The size of the array to initialize
     */
    public SnapshotArray(int length) {
        // Initialize array of lists to store snapshot history for each index
        snapshotHistory = new List[length];
        // Create an empty ArrayList for each array position
        Arrays.setAll(snapshotHistory, index -> new ArrayList<>());
        // Start with snapshot ID 0
        currentSnapId = 0;
    }

    /**
     * Set the value at the given index to val
     * @param index The index to set
     * @param val The value to set at the index
     */
    public void set(int index, int val) {
        // Add a new entry with current snapshot ID and value
        // This will be associated with the next snap() call
        snapshotHistory[index].add(new int[] {currentSnapId, val});
    }

    /**
     * Take a snapshot and return the snapshot ID
     * @return The snapshot ID that was just taken
     */
    public int snap() {
        // Return current snapshot ID and increment for next snapshot
        return currentSnapId++;
    }

    /**
     * Get the value at the given index for the specified snapshot ID
     * @param index The index to retrieve
     * @param snap_id The snapshot ID to query
     * @return The value at the index during the specified snapshot
     */
    public int get(int index, int snap_id) {
        // Binary search to find the rightmost entry with snapId <= snap_id
        int left = 0;
        int right = snapshotHistory[index].size();

        // Binary search for the first element with snapId > snap_id
        while (left < right) {
            int mid = (left + right) >> 1;  // Equivalent to (left + right) / 2

            if (snapshotHistory[index].get(mid)[0] > snap_id) {
                // Mid element's snapId is greater than target, search left half
                right = mid;
            } else {
                // Mid element's snapId is <= target, search right half
                left = mid + 1;
            }
        }

        // After binary search, left points to first element > snap_id
        // So we need the previous element (left - 1)
        left--;

        // If no valid snapshot found (left < 0), return default value 0
        // Otherwise return the value at the found snapshot
        return left < 0 ? 0 : snapshotHistory[index].get(left)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
