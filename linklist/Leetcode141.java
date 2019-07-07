/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode slow = head,fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if(fast == null)
                break;
            fast = fast.next;
        }while(slow!=fast && slow!=null && fast!=null);
        
        if(slow==null || fast==null)
            return false;
        return true;
    }
}