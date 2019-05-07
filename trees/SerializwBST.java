/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return null;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            root = q.poll();
            sb.append(root.val).append('-');
            if(root.left!=null)
                q.offer(root.left);
            if(root.right!=null)
                q.offer(root.right);
        }
        return sb.toString();
    }
    
    class Node {
        TreeNode root;
        int min,max;
        Node(TreeNode root,int min,int max){
            this.root = root;
            this.min = min;
            this.max = max;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String []token = data.split("-");
        //System.out.println(Arrays.toString(tokens));
        Queue <Node> q = new ArrayDeque<>();
        int i = 0;
        Node root = new Node(new TreeNode(Integer.parseInt(token[i])),Integer.MIN_VALUE,Integer.MAX_VALUE);
        q.offer(root);
        i++;
        int n = token.length;
        while(i<n){
            Node curr = q.poll();
            int next = 0; 
            if(i<n){
                next = Integer.parseInt(token[i]);
            
                if(next > curr.min && next < curr.root.val){
                    TreeNode newNode = new TreeNode(next);
                    curr.root.left = newNode;
                    Node nextNode = new Node(newNode,curr.min,curr.root.val);
                    q.offer(nextNode);
                    i++;
                }
            }
            if(i < n){
                next = Integer.parseInt(token[i]);
                if( next > curr.root.val && next < curr.max ){
                    TreeNode newNode = new TreeNode(next);
                    curr.root.right = newNode;
                    Node nextNode = new Node(newNode,curr.root.val,curr.max);
                    q.offer(nextNode);
                    i++;
                }
            }
        }
        return root.root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));