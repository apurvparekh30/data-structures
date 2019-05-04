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
        TreeNode root;
        int col;
        int level; 
        
        state(TreeNode root,int col,int level){
            this.root = root;
            this.col = col;
            this.level = level;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<state> q = new ArrayDeque<>();
        q.offer(new state(root,1,0));
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        while(!q.isEmpty()){
            state curr = q.poll();
            if(left.getOrDefault(curr.level,Integer.MAX_VALUE) > curr.col){
                left.put(curr.level,curr.col);
            }
            if(right.getOrDefault(curr.level,Integer.MIN_VALUE) < curr.col){
                right.put(curr.level,curr.col);
            }
            if(curr.root.left!=null)
                q.offer(new state(curr.root.left,curr.col * 2,curr.level+1));
            if(curr.root.right!=null)
                q.offer(new state(curr.root.right,curr.col * 2 + 1,curr.level+1));
        }
        //System.out.println(left + " " + right);
        int ans = 0;
        for(int key:left.keySet()){
            if(right.containsKey(key)){
                ans = Math.max(ans,right.get(key) - left.get(key) + 1);
            }
        }
        return ans;
    }
}