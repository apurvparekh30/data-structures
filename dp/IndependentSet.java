import java.io.*;
import java.util.*;
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
class GFG {
    
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    HashMap<Integer, Node> map = new HashMap<>();
		    
		    int n = sc.nextInt();
             
            Node root = null;
            Node parent;
		    while(n-- > 0){
		        int p = sc.nextInt();
		        if(!map.containsKey(p)){
		            root = new Node(p);
		            map.put(root.data, root);
		        }
		        parent = map.get(p);
		        
		        int ch = sc.nextInt();
		        Node child = new Node(ch);
		        
		        char c = sc.next().charAt(0);
		        if(c == 'L')
		            parent.left = child;
		        else if(c == 'R')
		            parent.right = child;
		            
		        map.put(ch, child);
		    }
		    
		    //inorder(root);
		    //System.out.println();
		    Solution obj = new Solution();
		    System.out.println(obj.LISS(root));
		}
	}
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/


/*
Structure of node class is as follows:
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/


class Solution {

    public int dp(Node root,int select){
        if(root == null)
            return 0;
        int ans = 0;
        if(select==1){
            ans = 1 + dp(root.left,1-select) + dp(root.left,1-select);
        }
        else {
            ans = Math.max(ans,dp(root.left,1-select) + dp(root.left,1-select));
        }
        return ans;
    }

    public int LISS(Node node){
        //Write your code here  
        return Math.max(dp(node,0),dp(node,1));     
    }
}