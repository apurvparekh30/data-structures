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
    
    TreeNode rec(TreeNode root,TreeNode p,TreeNode q){
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = rec(root.left,p,q);
        TreeNode right = rec(root.right,p,q);
        
        if(left!=null && right!=null)
            return root;
        return left==null ? right : left;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return rec(root,p,q);
    }
}