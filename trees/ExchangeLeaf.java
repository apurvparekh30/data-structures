// solution to Exchange the Leaf Nodes


import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString(){
        if(this == null)
            return "null";
        return data+"";
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
		    
		    Solution obj = new Solution();
		    obj.exchangeLeaves(root);
		    
		    inorder(root);
		    System.out.println();
		}
	}
}
class Solution {

    static class MyBoolean{
        boolean b;
        MyBoolean(boolean b){
            this.b = b;
        }
    }
   
    void rec(Node root,Node a,MyBoolean boo){
        if(root.left == null && root.right == null){
            System.out.println(a);
            boo.b = !boo.b;
            System.out.println("after "  + boo.b + " at " + root.data);
            if(boo.b){
                int temp = root.data;
                root.data = a.data;
                a.data = temp;
            }
            else{
                a = root;
            }
            return;
        }
        if(root.left!=null)
            rec(root.left,a,boo);
        if(root.right!=null)
            rec(root.right,a,boo);
    }

    public void exchangeLeaves(Node root){
        //Write your code here
        rec(root,null,new MyBoolean(true));
    }
}