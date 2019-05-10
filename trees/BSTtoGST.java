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
    
    class state {
        TreeNode node;
        int ret;
        state(TreeNode node,int ret){
            this.node = node;
            this.ret = ret;
        }
    } 
    
    public state rec(TreeNode root,int data){
        if(root==null){
            return new state(null,0);
        }
        System.out.println(root.val + " " + data);
        state right = rec(root.right,data);
        TreeNode newRoot = new TreeNode(data + root.val + right.ret);
        newRoot.right = right.node;
        state left = rec(root.left,newRoot.val);
        newRoot.left = left.node;
        return new state(newRoot,(newRoot.val + (root.left==null ? 0:root.left.val)));
    }
    
    public TreeNode bstToGst(TreeNode root) {
        return rec(root,0).node;
    }
}