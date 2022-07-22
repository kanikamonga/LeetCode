/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
          
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        if(root==null) return root; 
        while(!q.isEmpty()){
        
            int size = q.size();
            
            for(int i=0;i<size;i++){
                Node node = q.poll();
                node.next = i==size-1?null:q.peek();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);            
            }
        
            
        }
        
        return root;
    }
}