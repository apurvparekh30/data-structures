import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (root == null) {
                    root = new Node(a);
                } else {
                    insert(root, a);
                }
            }
            int x = sc.nextInt();
            // Node k=search(root,x);
            Node k = new Node(x);
            GfG g = new GfG();
            root = g.inorderSuccessor(root, k);
            if (root == null)
                System.out.print("-1");
            else
                System.out.print(root.data);
            // inorder(root);
            System.out.println();
        }
    }

    /*
     * public static void inorder(Node root){ if(root==null) return;
     * inorder(root.left); System.out.print(root.data+" "); inorder(root.right); }
     */
    public static Node insert(Node root, int a) {
        if (root == null) {
            return new Node(a);
        }
        if (root.data > a) {
            root.left = insert(root.left, a);
        }
        if (root.data < a) {
            root.right = insert(root.right, a);
        }
        return root;
    }

    public static Node search(Node root, int x) {
        if (root == null || root.data == x)
            return root;
        if (root.data > x)
            search(root.left, x);
        if (root.data < x)
            search(root.right, x);
        return root;
    }
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left,right; Node(int d){ data=d; left=right=null; } }
 */
class GfG {
    Node minValue(Node root){
        if(root==null)
            return null;
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public Node inorderSuccessor(Node root, Node k) {
        // add code here.
        return minValue(k.right);
    }
}