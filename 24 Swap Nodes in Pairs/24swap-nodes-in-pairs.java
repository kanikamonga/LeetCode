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
    public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1);
             dummy.next = head;
        
            ListNode prev = dummy;
            ListNode nextnode = null;
        while(prev.next!=null && prev.next.next!=null ){
           ListNode next = prev.next; //1
            ListNode next2 = prev.next.next; //2
            next.next = next2.next; //1->3
            next2.next = next; //2->1
            prev.next= next2; //-1->2
            prev = next; //1
            
        }
        
        return dummy.next;
        
        
    }
}