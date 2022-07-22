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
     TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        
      findswap(root);
       
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        
        
    }
    
    
  public void findswap(TreeNode root){
        if(root == null) return;

     findswap(root.left);

    
          if(first==null && prev.val>root.val){
              first = prev;
          }  if(first!=null && prev.val>root.val){
              second = root;
          }
          
      
      
      
      prev = root;
      
      findswap(root.right);
  
    }
}