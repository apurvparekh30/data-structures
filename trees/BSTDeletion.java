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
    
    TreeNode getSuccessor(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        else {
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else {
                TreeNode temp = getSuccessor(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right,temp.val);
            }
        }
        return root;
    }
}