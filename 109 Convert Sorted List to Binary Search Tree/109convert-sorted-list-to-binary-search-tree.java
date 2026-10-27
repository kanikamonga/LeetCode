/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        this.node = head;   
        return buildBST(getSize(head));
    }

    public TreeNode buildBST(int size){
        if(size<=0) return null;
        TreeNode left = buildBST(size/2);
        TreeNode root = new TreeNode (node.val);
        node = node.next;
        root.left = left;
        root.right = buildBST(size-1-size/2);
        return root;

    }


    public int getSize(ListNode head){
        int size = 0;

        while(head!=null){
            size++;
            head = head.next;
        }
        return size;
    }
}