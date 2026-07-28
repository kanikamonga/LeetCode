class UnionFind {
    private int[] parent;  // parent[i] stores the parent of node i
    private int[] size;     // size[i] stores the size of the tree rooted at i
  
    /**
     * Initialize Union-Find structure with n elements (0 to n-1)
     * @param n number of elements
     */
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
      
        // Initially, each element is its own parent (separate sets)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
  
    /**
     * Find the root/representative of the set containing element x
     * Uses path compression for optimization
     * @param x the element to find
     * @return the root of the set containing x
     */
    public int find(int x) {
        // Path compression: make all nodes on path point directly to root
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
  
    /**
     * Union two sets containing elements a and b
     * Uses union by size for optimization
     * @param a first element
     * @param b second element
     * @return true if union was performed, false if already in same set
     */
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
      
        // Already in the same set
        if (rootA == rootB) {
            return false;
        }
      
        // Union by size: attach smaller tree under larger tree
        if (size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
      
        return true;
    }
}

/**
 * Solution class for checking connectivity based on common divisors
 */
class Solution {
    /**
     * Determines if pairs of cities are connected through common divisors greater than threshold
     * Two cities are connected if they share a common divisor > threshold
     * @param n number of cities (1 to n)
     * @param threshold minimum divisor value
     * @param queries array of city pairs to check connectivity
     * @return list of boolean values indicating connectivity for each query
     */
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        // Create Union-Find for n+1 elements (cities numbered 1 to n)
        UnionFind unionFind = new UnionFind(n + 1);
      
        // Connect all cities that share common divisors greater than threshold
        // For each potential divisor starting from threshold+1
        for (int divisor = threshold + 1; divisor <= n; divisor++) {
            // Connect all multiples of this divisor
            // Start from 2*divisor and increment by divisor to get all multiples
            for (int multiple = divisor + divisor; multiple <= n; multiple += divisor) {
                unionFind.union(divisor, multiple);
            }
        }
      
        // Process queries and check connectivity
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            // Two cities are connected if they belong to the same set
            boolean isConnected = unionFind.find(query[0]) == unionFind.find(query[1]);
            result.add(isConnected);
        }
      
        return result;
    }
}
