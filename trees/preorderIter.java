import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
     * you only have to complete the function given below. Node is defined as
     * 
     * class Node { int data; Node left; Node right; }
     * 
     */

    public static void preOrder(Node root) {
        ArrayDeque<Node> ad = new ArrayDeque<>();
        while(true){
            if(root==null && ad.isEmpty())
                break;
            while(root!=null){
                System.out.printf("%d " ,root.data);
                ad.addLast(root);
                root=root.left;
            }
            Node top = ad.pollLast();
            root=top.right;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}