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
    public ListNode sortList(ListNode head) {
          if (head==null || head.next==null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode head1 = head;
        ListNode head2 = mid.next;
        mid.next = null;
        return merge (sortList(head1),sortList(head2));
    }

    public ListNode merge(ListNode head1,ListNode head2){
        ListNode head;
        if (head1==null) {
            return head2;
        }
        if (head2==null) {
            return head1;
        }
        if (head1.val<head2.val) {
            head = head1;
            head1 = head1.next;
        }
        else{
            head = head2;
            head2 = head2.next;
        }
        ListNode t = head;
        while (head1!=null && head2!=null) {
            if (head1.val<head2.val) {
                t.next = head1;
                head1 = head1.next;
                t = t.next;
            }
            else {
                t.next = head2;
                head2 = head2.next;
                t = t.next;
            }
        }
        if (head1==null) {
            t.next = head2;
        }
        if (head2==null) {
            t.next = head1;
        }
        return head;
    }

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}