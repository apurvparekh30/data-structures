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
    
    int pe = 0;
    
    public TreeNode rec(int low,int high,int []preorder,int []inorder){
        int m = 0;
        int e = preorder[pe];
        TreeNode root = new TreeNode(e);
        for(int i=low;i<=high;i++){
            if(inorder[i]==e){
                m = i;
                break;
            }
        }
        if(low < m){
            pe++;
            root.left = rec(low,m-1,preorder,inorder);
        }
        if(high > m){
            pe++;
            root.right = rec(m+1,high,preorder,inorder);
        }
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        return rec(0,preorder.length-1,preorder,inorder);
    }
}