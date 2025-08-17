/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // To store the adjacency list representation of the binary tree
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    // Calculates the amount of time needed to infect all nodes starting from 'start' node
    public int amountOfTime(TreeNode root, int start) {
        // Convert tree to graph (adjacency list)
        convertToGraph(root);
        // Queue for the Breadth First Search (BFS)
        Deque<Integer> queue = new ArrayDeque<>();
        // Set to track visited nodes
        Set<Integer> visited = new HashSet<>();
      
        // Offer the starting node into the queue
        queue.offer(start);
        int time = -1; // Initialize time to -1 because we increase time before processing the nodes
      
        while (!queue.isEmpty()) {
            time++; // Increase time as we are moving to the next level of nodes
          
            // Loop through the nodes at the current level
            for (int i = queue.size(); i > 0; i--) {
                int currentNode = queue.pollFirst();
                visited.add(currentNode);
              
                // Get the neighbors of the current node
                if (adjacencyList.containsKey(currentNode)) {
                    for (int neighbor : adjacencyList.get(currentNode)) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return time; // Return the total time taken to infect all nodes
    }

    // Helper method to convert the binary tree to a graph represented as an adjacency list
    private void convertToGraph(TreeNode node) {
        if (node == null) {
            return;
        }
      
        // Connect the current node with its left child
        if (node.left != null) {
            adjacencyList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.left.val);
            adjacencyList.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
        }
      
        // Connect the current node with its right child
        if (node.right != null) {
            adjacencyList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
            adjacencyList.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
        }
      
        // Recursively convert the left and right subtrees to the graph
        convertToGraph(node.left);
        convertToGraph(node.right);
    }
}
