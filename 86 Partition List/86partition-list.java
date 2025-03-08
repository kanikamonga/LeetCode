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
    public ListNode partition(ListNode head, int x) {
        //base case
        if(head==null || head.next==null) return head;

        ListNode prev=new ListNode();
        ListNode next=new ListNode();
        ListNode prevHead=prev, nextHead=next;

        while(head != null){
            if(head.val < x){
                prevHead.next=head;
                prevHead=prevHead.next;
            }else if(head.val >= x){
                nextHead.next=head;
                nextHead=nextHead.next;
            }
            head=head.next;
        }

        nextHead.next=null;
        prevHead.next=next.next;
        return prev.next;
    }
}