class Solution {
    // Parent array for Union-Find (Disjoint Set Union)
    private int[] parent;

    /**
     * Determines the minimum number of operations needed to make all computers connected.
     * 
     * @param n           The number of computers (nodes)
     * @param connections The existing connections between computers (edges)
     * @return The minimum number of operations needed, or -1 if impossible
     */
    public int makeConnected(int n, int[][] connections) {
        // Initialize parent array where each node is its own parent initially
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
      
        // Count redundant connections (cables that connect already connected components)
        int redundantCables = 0;
      
        // Process each connection
        for (int[] connection : connections) {
            int node1 = connection[0];
            int node2 = connection[1];
          
            // Find the root parents of both nodes
            int parentOfNode1 = find(node1);
            int parentOfNode2 = find(node2);
          
            if (parentOfNode1 == parentOfNode2) {
                // Nodes are already in the same component - this cable is redundant
                redundantCables++;
            } else {
                // Union: Connect the two components by making one parent point to the other
                parent[parentOfNode1] = parentOfNode2;
                // Decrease the count of disconnected components
                n--;
            }
        }
      
        // n now represents the number of disconnected components
        // We need (n - 1) cables to connect n components
        // Check if we have enough redundant cables to reconnect all components
        int cablesNeeded = n - 1;
        return cablesNeeded > redundantCables ? -1 : cablesNeeded;
    }

    /**
     * Finds the root parent of a node using path compression optimization.
     * 
     * @param x The node to find the root parent for
     * @return The root parent of the node
     */
    private int find(int x) {
        if (parent[x] != x) {
            // Path compression: Make the node directly point to its root parent
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
