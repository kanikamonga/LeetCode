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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        List<List<Integer>> r = new ArrayList<>();
        if(root==null) return r; 
        while(!q.isEmpty()){
            List<Integer> res = new ArrayList<>();
        
            int size = q.size();
            
            while(size>0){
                TreeNode node = q.poll();
                res.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);            
                size--;
            }
            r.add(res);
            
        }
        
        return r;
        
    }
}