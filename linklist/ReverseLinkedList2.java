/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        ListNode mth = null;
        ListNode m1 = null;
        int i = 1;
        while(i <= n){
            if(i==m-1){
                m1 = curr;
            }
            if(i==m){
                mth = curr;
            }
            //System.out.println((m1!=null ? m1.val : "null"));
            //System.out.println((mth!=null ? mth.val : "null"));
            if(i==n ){
                if(m1==null){
                    head = curr;
                }
                else {
                    m1.next = curr;
                }
                
            }
            if(i > m && i <= n){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
            i++;
        }
        mth.next = curr;
        return head;
    }
}