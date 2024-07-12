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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> list = new ArrayList<>();
        if (root == null) return list;
        
        HashSet<Integer> to_delete_set = new HashSet<>();
        for (int i : to_delete) to_delete_set.add(i);
        
        root = inorder(root, to_delete_set, list);
        if (root != null) list.add(root);
        
        return list;
    }

    private TreeNode inorder(TreeNode root, HashSet<Integer> to_delete_set, List<TreeNode> list) {
        
        if (root != null) {
            
            root.left = inorder(root.left, to_delete_set, list);
            root.right = inorder(root.right, to_delete_set, list);
            
            if (to_delete_set.contains(root.val)) {
                if (root.left != null) list.add(root.left);
                if (root.right != null) list.add(root.right);
                return null;
            }
            
            return root;
        } 
        return null;

    }
        
    
}