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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        int k=0;
        while(++k<left){
            tail = tail.next;
        }
        //tail = 2
        
        ListNode rTail = tail.next; //3
        
        while(++k<=right){
           ListNode temp = tail.next; //3
           tail.next  = rTail.next;//3->4
           rTail.next = rTail.next.next;//3->5
           tail.next.next= temp;//3->2            
            
        }
        
        return dummy.next;
        
        
        
    }
}