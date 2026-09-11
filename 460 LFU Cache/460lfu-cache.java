class LFUCache {
    // Map to store key-node pairs for O(1) access
    private final Map<Integer, Node> cache;
    // Map to store frequency-list pairs, where each list contains nodes with same frequency
    private final Map<Integer, DoublyLinkedList> frequencyMap;
    // Maximum capacity of the cache
    private final int capacity;
    // Track the minimum frequency in the cache for eviction
    private int minFrequency;

    /**
     * Initialize the LFU cache with given capacity
     * @param capacity Maximum number of key-value pairs the cache can hold
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity, 1);
        this.frequencyMap = new HashMap<>();
        this.minFrequency = 0;
    }

    /**
     * Get the value of the key if it exists in the cache
     * @param key The key to look up
     * @return The value associated with the key, or -1 if key doesn't exist
     */
    public int get(int key) {
        // Handle edge case of zero capacity
        if (capacity == 0) {
            return -1;
        }
      
        // Key not found in cache
        if (!cache.containsKey(key)) {
            return -1;
        }
      
        // Key exists - update frequency and return value
        Node node = cache.get(key);
        incrementFrequency(node);
        return node.value;
    }

    /**
     * Update the value of the key if present, otherwise insert the key-value pair
     * @param key The key to insert or update
     * @param value The value to associate with the key
     */
    public void put(int key, int value) {
        // Handle edge case of zero capacity
        if (capacity == 0) {
            return;
        }
      
        // Update existing key
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            incrementFrequency(node);
            return;
        }
      
        // Remove least frequently used item if cache is full
        if (cache.size() == capacity) {
            DoublyLinkedList minFrequencyList = frequencyMap.get(minFrequency);
            Node nodeToRemove = minFrequencyList.removeLast();
            cache.remove(nodeToRemove.key);
        }
      
        // Add new node to cache
        Node newNode = new Node(key, value);
        addNodeToFrequencyMap(newNode);
        cache.put(key, newNode);
        minFrequency = 1; // New node always has frequency 1
    }

    /**
     * Increment the frequency of a node and move it to appropriate frequency list
     * @param node The node whose frequency needs to be incremented
     */
    private void incrementFrequency(Node node) {
        int currentFrequency = node.frequency;
      
        // Remove node from current frequency list
        DoublyLinkedList currentList = frequencyMap.get(currentFrequency);
        currentList.remove(node);
      
        // Clean up empty frequency list and update minFrequency if needed
        if (currentList.isEmpty()) {
            frequencyMap.remove(currentFrequency);
            if (currentFrequency == minFrequency) {
                minFrequency++;
            }
        }
      
        // Increment frequency and add to new frequency list
        node.frequency++;
        addNodeToFrequencyMap(node);
    }

    /**
     * Add a node to the frequency map based on its current frequency
     * @param node The node to add to frequency map
     */
    private void addNodeToFrequencyMap(Node node) {
        int frequency = node.frequency;
      
        // Get or create the list for this frequency
        DoublyLinkedList list = frequencyMap.computeIfAbsent(frequency, 
            k -> new DoublyLinkedList());
      
        // Add node to the front of the list (most recently used)
        list.addFirst(node);
    }

    /**
     * Node class representing a cache entry
     */
    private static class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1; // Initial frequency is always 1
        }
    }

    /**
     * Doubly linked list to maintain LRU order within same frequency
     */
    private static class DoublyLinkedList {
        // Dummy head and tail nodes to simplify operations
        private final Node head;
        private final Node tail;

        public DoublyLinkedList() {
            // Initialize dummy nodes
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Add a node to the front of the list (most recently used position)
         * @param node The node to add
         */
        public void addFirst(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        /**
         * Remove a specific node from the list
         * @param node The node to remove
         * @return The removed node
         */
        public Node remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
            return node;
        }

        /**
         * Remove the last node from the list (least recently used)
         * @return The removed node
         */
        public Node removeLast() {
            return remove(tail.prev);
        }

        /**
         * Check if the list is empty
         * @return true if list is empty, false otherwise
         */
        public boolean isEmpty() {
            return head.next == tail;
        }
    }
}
