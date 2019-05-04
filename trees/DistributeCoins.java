
class Solution {

    public int rec1(TreeNode root) {
		int res = 0;
		int left,right;
		if(root.left!=null){
			left = rec1(root.left);
			root.val = root.left.val - 1;
			res += Math.abs(left);
		}
		if(root.right!=null){
			right = rec1(root.right);
			root.val = root.right.val - 1;
			res += Math.abs(right);
		}	
		return res = res + root.val - 1;
	}	
	
    public int distributeCoins(TreeNode root) {
		return rec1(root);
    }
}
