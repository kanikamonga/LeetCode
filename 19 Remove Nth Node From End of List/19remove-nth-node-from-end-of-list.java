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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node pointing to head to handle edge case when removing the first node
        ListNode dummyNode = new ListNode(0, head);
      
        // Initialize two pointers both starting at dummy node
        ListNode fastPointer = dummyNode;
        ListNode slowPointer = dummyNode;
      
        // Move fast pointer n steps ahead to create a gap of n nodes between fast and slow
        while (n > 0) {
            fastPointer = fastPointer.next;
            n--;
        }
      
        // Move both pointers simultaneously until fast pointer reaches the last node
        // This ensures slow pointer stops at the node just before the target node
        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
      
        // Remove the nth node from end by skipping it in the linked list
        slowPointer.next = slowPointer.next.next;
      
        // Return the head of the modified list (dummy.next handles case when original head was removed)
        return dummyNode.next;
    }
}
