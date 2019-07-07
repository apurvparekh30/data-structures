/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    /*ListNode get(ListNode curr,ListNode last){
        while(curr!=last && curr.next!=last){
            curr = curr.next;
        }
        return curr;
    }*/
    
    class Ret {
        ListNode curr,prev,next;
        Ret(ListNode curr,ListNode prev,ListNode next){
            this.curr = curr;
            this.prev = prev;
            this.next = next;
        }
    }
    
    void quickSort(ListNode first,ListNode last){
        if(first==null || last==null)
            return;
        if(first!=last && last.next!=first){
            Ret p = partition(first,last);
            quickSort(first,p.prev);
            quickSort(p.next,last);
        }
    }
    
    Ret partition(ListNode first,ListNode last){
        ListNode curr = first;
        ListNode prev = null;
        ListNode next = null;
        while(first!=last){
            if(first.val <= last.val){
                int temp = curr.val;
                curr.val = first.val;
                first.val = temp;
                prev = curr;
                curr = curr.next;
            }
            first = first.next;
        }
        int temp = curr.val;
        curr.val = last.val;
        last.val = temp;
        next = curr.next;
        return new Ret(curr,prev,next);
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        ListNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        quickSort(head,curr);
        return head;
    }
}