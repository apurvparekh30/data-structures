/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode curr = root;
        while(curr!=null){
            curr = curr.next;
            size++;
        }
        int parts = size / k;
        int extra = size % k;
        curr = root;
        int temp = 0;
        ListNode []nodes = new ListNode[k];
        for(int i=0;i<k;i++){
            ListNode head = curr;
            ListNode prev = curr;
            for(int j=0; j < parts + (extra > 0 ? 1 : 0);j++){
                prev = curr;
                curr = curr.next;
            }
            if(prev!=null) prev.next = null;
            nodes[i] = head;
            extra--;
        }
        return nodes;
    }
}