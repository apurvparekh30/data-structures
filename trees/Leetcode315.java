class Solution {
    
    class TreeNode {
        int data,sum,dup;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
        }
    }
    
    TreeNode insert(TreeNode root,int data,int i,Integer []ans,int pre){
        if(root == null){
            TreeNode newNode = new TreeNode(data);
            ans[i] = pre;
            return newNode;
        }
        if(data < root.data){
            root.sum++;
            root.left = insert(root.left,data,i,ans,pre);
        }
        else if(data > root.data){
            root.right = insert(root.right,data,i,ans,root.sum + root.dup + pre + 1);
        }
        else {
            root.dup++;
            ans[i] = pre + root.sum;
        }
        return root;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if(n == 0) return new ArrayList<>();
        TreeNode root = null;
        Integer []ans = new Integer[n];
        for(int i=n-1;i>=0;i--){
            root = insert(root,nums[i],i,ans,0);
        }
        return Arrays.asList(ans);
    }
}