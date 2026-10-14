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
    // Previous node visited during in-order traversal
    private TreeNode previousNode;
  
    // First swapped node (larger value in wrong position)
    private TreeNode firstSwappedNode;
  
    // Second swapped node (smaller value in wrong position)
    private TreeNode secondSwappedNode;

    /**
     * Recovers a binary search tree where exactly two nodes have been swapped by mistake.
     * The recovery is done by swapping back the values of the two incorrect nodes.
     * 
     * @param root The root of the binary search tree to recover
     */
    public void recoverTree(TreeNode root) {
        // Perform in-order traversal to identify the two swapped nodes
        inOrderTraversal(root);
      
        // Swap the values of the two identified nodes to recover the BST
        int temp = firstSwappedNode.val;
        firstSwappedNode.val = secondSwappedNode.val;
        secondSwappedNode.val = temp;
    }

    /**
     * Performs an in-order traversal of the tree to identify nodes that violate BST property.
     * In a valid BST, in-order traversal yields values in ascending order.
     * When two nodes are swapped, there will be one or two violations of this order.
     * 
     * @param currentNode The current node being visited in the traversal
     */
    private void inOrderTraversal(TreeNode currentNode) {
        // Base case: if current node is null, return
        if (currentNode == null) {
            return;
        }
      
        // Recursively traverse the left subtree
        inOrderTraversal(currentNode.left);
      
        // Process current node: check for BST violation
        if (previousNode != null && previousNode.val > currentNode.val) {
            // Found a violation where previous value is greater than current value
          
            // If this is the first violation found, mark the previous node as first swapped node
            if (firstSwappedNode == null) {
                firstSwappedNode = previousNode;
            }
          
            // Always update the second swapped node to current node
            // This handles both adjacent and non-adjacent swapped nodes
            secondSwappedNode = currentNode;
        }
      
        // Update previous node for next comparison
        previousNode = currentNode;
      
        // Recursively traverse the right subtree
        inOrderTraversal(currentNode.right);
    }
}
