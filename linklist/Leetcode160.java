/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null)
            return null;
        
        ListNode curr = headA;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = headB;
        ListNode slow = headA;
        ListNode fast = headA;
        
        do {
            slow = slow.next;
            fast = fast.next;
            if(fast==null)
                break;
            fast = fast.next;
        } while(slow!=fast && slow!=null && fast!=null);
        
        if(slow==null || fast == null){
            curr.next = null;
            return null;
        }
            
        
        slow = headA;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        curr.next = null;
        return slow;
    }
}