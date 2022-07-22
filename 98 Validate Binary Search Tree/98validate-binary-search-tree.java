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
    public boolean isValidBST(TreeNode root) {
        
      return  validBST(Long.MIN_VALUE,Long.MAX_VALUE,root);
       
        
    }
    
    public boolean validBST(long min,long max,TreeNode root){
        if(root == null) return true;
        
        if(root.val>=max || root.val<=min) return false;
        
        return validBST(min,(long)root.val,root.left) && validBST((long)root.val,max,root.right);
            
    }
    
    
}