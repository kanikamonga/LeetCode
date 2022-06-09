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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode result =  new ListNode(0);
        ListNode head =  result;
        
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            ListNode temp = new ListNode();
            temp.val = sum%10;
            temp.next = null;
            result.next = temp;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum/10;
        }

        
        while(l1!=null){
            int sum = l1.val+carry;
            ListNode temp = new ListNode();
            temp.val = sum%10;
            temp.next = null;
            result.next = temp;
            result = result.next;
            l1 = l1.next;
            carry = sum/10;
        }
          while(l2!=null){
            int sum = l2.val+carry;
            ListNode temp = new ListNode();
            temp.val = sum%10;
            temp.next = null;
            result.next = temp;
            result = result.next;
            l2 = l2.next;
            carry = sum/10;
        }
        
        if(carry!=0){
            ListNode temp = new ListNode();
            temp.val = carry;
            temp.next = result;
            temp.next = null;
            result.next = temp;
        }
        return head.next;
    }
    
    
}