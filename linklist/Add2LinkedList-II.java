/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int getSize(ListNode a){
        int n = 0;
        while(a!=null){
            n++;
            a = a.next;
        }
        return n;
    }
    
    public ListNode rec(int n,int m,ListNode a,ListNode b){
        if(n==0 && m==0){
            return null;
        }
        ListNode tmp;
        int aa = 0;
        int bb = 0;
        if(n > m){
            aa = a.val;
            tmp = rec(n-1,m,a.next,b);
        }
        else if(m > n){
            bb = b.val;
            tmp = rec(n,m-1,a,b.next);
        }
        else {
            aa = a.val;
            bb = b.val;
            tmp = rec(n-1,m-1,a.next,b.next);
        }
        ListNode newNode = new ListNode(aa+bb);
        newNode.next = tmp;
        if(tmp!=null){
            newNode.val = newNode.val + (tmp.val)/10;
            tmp.val = tmp.val % 10;
        }
        return newNode;
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = getSize(l1);
        int m = getSize(l2);
        ListNode head = rec(n,m,l1,l2);
        if(head!=null && head.val > 9){
            ListNode newHead = new ListNode(head.val/10);
            head.val = head.val % 10;
            newHead.next = head;
            return newHead;
        }
        return head;
    }
}