/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    
    class State {
        Node node;
        int depth;
        State(Node node,int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    
    public Node connect(Node root) {
        if(root == null)
            return null;
        Map<Integer,Node> map = new HashMap<>();
        Queue<State> q = new LinkedList();
        q.offer(new State(root,0));
        while(!q.isEmpty()){
            State curr = q.poll();
            if(map.containsKey(curr.depth)){
                Node prev = map.get(curr.depth);
                prev.next = curr.node;
            }
            map.put(curr.depth,curr.node);
            if(curr.node.left!=null)
                q.offer(new State(curr.node.left,curr.depth+1));
            if(curr.node.right!=null)
                q.offer(new State(curr.node.right,curr.depth+1));
        }
        for(int key:map.keySet()){
            Node curr = map.get(key);
            curr.next = null;
        }
        return root;
    }
}