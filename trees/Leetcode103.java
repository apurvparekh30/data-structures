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
    
    
    class State {
        TreeNode root;
        int lvl;
        State(TreeNode root,int lvl){
            this.root = root;
            this.lvl = lvl;
        }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        if(root == null)
            return sol;
        Queue<State> q = new LinkedList<>();
        q.offer(new State(root,0));
        while(!q.isEmpty()){
            State curr = q.poll();
            if(sol.size() == curr.lvl){
                sol.add(curr.lvl,new LinkedList<>());
            }
            List<Integer> list = sol.get(curr.lvl);
            if(curr.lvl%2==1)
                list.add(0,curr.root.val);
            else 
                list.add(curr.root.val);
            if(curr.root.left!=null)
                q.offer(new State(curr.root.left,curr.lvl+1));
            if(curr.root.right!=null)
                q.offer(new State(curr.root.right,curr.lvl+1));
        }
        return sol;
    }
}