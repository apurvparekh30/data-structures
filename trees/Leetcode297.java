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
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //sb.append("[");
        boolean comma = false;
        StringBuilder nullString = new StringBuilder();
        while(!q.isEmpty()){
            root = q.poll();
            if(root==null){
                if(comma)
                    nullString.append(',');
                comma = true;
                nullString.append("null");
                continue;
            }
            else {
                sb.append(nullString.toString());
                nullString = new StringBuilder();
                if(comma)
                    sb.append(',');
                comma = true;
                sb.append(root.val);
            }
            q.offer(root.left);
            q.offer(root.right);
        }
        //sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String []tokens = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        int i = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            TreeNode left = null, right = null;
            if(i < tokens.length && !tokens[i].equals("null"))
                left = new TreeNode(Integer.parseInt(tokens[i]));
            i++;
            if(i < tokens.length && !tokens[i].equals("null"))
                right = new TreeNode(Integer.parseInt(tokens[i]));
            i++;
            
            curr.left = left;
            curr.right = right;
            if(left!=null)
                q.offer(left);
            if(right!=null)
                q.offer(right);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));