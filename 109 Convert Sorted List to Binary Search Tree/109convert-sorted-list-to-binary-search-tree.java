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
    ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {

            int size = getBstSize(head);
            curr = head;
            return bstBuilder(size);


        
    }

    public TreeNode bstBuilder(int size){
        if(size <=0) return null;
        TreeNode left = bstBuilder(size/2);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = bstBuilder(size-1- size/2);
        root.left = left;
        root.right = right;
        return root;



    }

    public int getBstSize(ListNode node){
        int size=0;
        while(node!=null){
            node = node.next;
            size++;
        }
        return size;
    }

}