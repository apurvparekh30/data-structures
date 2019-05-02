/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class pair {
        int i;
        ListNode h;
        pair(int i,ListNode h){
            this.i = i;
            this.h = h;
        }
    }
    
    public int[] nextLargerNodes(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode curr = head;
        int n = 0;
        while(curr!=null){
            n++;
            curr = curr.next;
        }
        
        int []arr = new int[n];
        Stack<pair> st = new Stack<>();
        st.push(new pair(0,head));
        
        head = head.next;
        int i = 1;
        while(head!=null){
            int currVal = head.val;
            while(!st.isEmpty() && st.peek().h.val < currVal) {
                arr[st.peek().i] = currVal;
                st.pop();
            }
            st.push(new pair(i,head));
            head = head.next;
            i++;
        }
        return arr;
    }
}