class Solution {
    int i, o; // i: inorder traversal idx, o: postorder traversal idx;
    public TreeNode buildTree(int[] in, int[] po) {
        i = o = po.length - 1;
        return dfs(in, po, Integer.MAX_VALUE);
    }
    
    private TreeNode dfs(int[] in, int[] po, int leftBoundary) {
        if (o == -1 || in[i] == leftBoundary) return null;
        TreeNode node = new TreeNode(po[o--]);
        node.right = dfs(in, po, node.val);
        i--;
        node.left  = dfs(in, po, leftBoundary);
        return node;
    }
}