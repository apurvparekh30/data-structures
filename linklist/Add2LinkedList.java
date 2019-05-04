/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        ListNode prev = a;
        while(a!=null || b!=null){
            int aa = (a==null) ? 0:a.val;
            int bb = (b==null) ? 0:b.val;

            int sum = aa + bb + carry;
            carry = sum / 10;
            if(a == null){
                a = new ListNode(0);
                prev.next = a;
            }
            a.val = sum % 10;
            prev = a;
            if(a!=null)
                a = a.next;
            if(b!=null)
                b = b.next;
        }
        if(carry == 1){
            prev.next = new ListNode(carry);
        }
        return l1;
    }
}