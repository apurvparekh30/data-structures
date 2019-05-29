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
    
    int maxValue = Integer.MIN_VALUE;
    
    int rec(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(0,rec(root.left));
        int right = Math.max(0,rec(root.right));
        maxValue = Math.max(maxValue,root.val + left + right);
        return Math.max(left,right) + root.val;
    }
    
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        rec(root);
        return maxValue;
    }
}