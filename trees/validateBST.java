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
    boolean rec(TreeNode root,long low,long high){
        //System.out.println("hello" + low + " " + high);
        if(root==null)
            return true;
        return (root.val >= low && root.val <= high) && rec(root.left,low,((long)(root.val))-1) && rec(root.right,((long)(root.val))+1,high);
    }
    public boolean isValidBST(TreeNode root) {
        return rec(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}