/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode rec(ListNode head,ListNode tail){
        if(head==tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail && fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = rec(head,slow);
        root.right = rec(slow.next,tail);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return rec(head,null);
    }
}