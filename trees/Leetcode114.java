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
    
    TreeNode get(TreeNode root){
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }
    
    void rec(TreeNode root){
        if(root!=null){
            rec(root.right);
            rec(root.left);
            if(root.left!=null){
                TreeNode mostRight = get(root.left);
                mostRight.right = root.right;
                root.right = root.left;
                root.left = null;
            }            
        }
    }
    
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        rec(root);
    }
}