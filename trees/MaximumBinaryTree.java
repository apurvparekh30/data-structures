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
    
    int getMaxIndex(int i,int j,int []nums){
        int max = nums[i];
        int maxIndex = i;
        for(int k=i+1;k<=j;k++){
            if(max < nums[k]){
                max = nums[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    TreeNode rec(int i,int j,int []nums){
        if(i>j)
            return null;
        int k = getMaxIndex(i,j,nums);
        TreeNode newNode = new TreeNode(nums[k]);
        newNode.left = rec(i,k-1,nums);
        newNode.right = rec(k+1,j,nums);
        return newNode;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0)
            return null;
        return rec(0,nums.length-1,nums);
    }
}