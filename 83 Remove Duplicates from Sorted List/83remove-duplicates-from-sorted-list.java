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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;

        ListNode cur = head;
        ListNode next = head.next;

        while(cur!=null && next!=null){
            if(cur.val == next.val){
                cur.next = next.next;
            }else{
                cur = next;
            }
             next = cur.next;
        }
        return head;
    }
}