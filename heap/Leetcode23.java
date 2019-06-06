/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class ListComparater implements Comparator<ListNode> {
        @Override 
        public int compare(ListNode a,ListNode b){
            return a.val - b.val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] list) {
        if(list==null || list.length==0)
            return null;
        int n = list.length;
        Queue<ListNode> q = new PriorityQueue<>(new ListComparater());
        for(int i=0;i<n;i++){
            if(list[i]!=null){
                q.offer(list[i]);
            }
        }
        
        ListNode ret = null;
        ListNode head = ret;
        while(!q.isEmpty()){
            ListNode curr = q.poll();
            ListNode prev = curr;
            curr = curr.next;
            if(ret == null){
                ret = prev;
                head = ret;
            }
            else {
                ret.next = prev;
                ret = ret.next;
            }
                
            if(curr!=null)
                q.offer(curr);
        }
        return head;
    }
}