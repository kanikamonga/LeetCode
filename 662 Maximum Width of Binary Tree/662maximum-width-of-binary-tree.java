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
    public int widthOfBinaryTree(TreeNode root) {
       if (root == null) {
            return 0;
        }

        int ans = 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
          
            int prevMinIndex = q.peek().getValue();

            int first=0, last=0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode,Integer> pair = q.poll();
                int cur_index = pair.getValue() - prevMinIndex;
                TreeNode node = pair.getKey();
               

                if (i == 0) {
                    first = cur_index;
                }

                if (i == size - 1) {
                    last = cur_index;
                }

                
                if (node.left != null) {
                    q.add(new Pair<>(node.left, cur_index * 2));
                }

                
                if (node.right != null) {
                    q.add(new Pair<>(node.right, cur_index * 2+1));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        // Return the maximum
        // width of the binary tree
        return ans;
    }
}

class TreeNodeInfo {
    TreeNode node;
    int num;
    int level;
    
    TreeNodeInfo(TreeNode node, int num, int level) {
        this.node = node;
        this.num = num;
        this.level = level;
    }
}