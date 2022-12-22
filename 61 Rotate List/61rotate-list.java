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
    public ListNode rotateRight(ListNode head, int k) {
           if(head == null || head.next == null || k == 0) return head;
        
       int len = 0;
        ListNode tail = head;
        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        len++;

        k = len - k % len;
        if(k == len) return head;
        ListNode rTail = head;
        
        for(int i=0;i<k-1;i++){
            rTail = rTail.next;
        }
        
        ListNode newHead = rTail.next;
        rTail.next = null;
        tail.next = head;

        return newHead;
    
    }
}