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
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<>();
        
        while(root!=null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                k--;
                if(k == 0){
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }
}