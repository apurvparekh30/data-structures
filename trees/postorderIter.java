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

    public static void postOrder(Node root) {
        ArrayDeque<Node> ad = new ArrayDeque<>();
        while(true){
            if(root==null && ad.isEmpty())
                break;
            if(root!=null){
                ad.addLast(root);
                root=root.left;
            }
            else{
                Node tmp = ad.peekLast().right;
                if(tmp==null){
                    tmp = ad.pollLast();
                    System.out.printf("%d ",tmp.data);
                    while(!ad.isEmpty() && tmp == ad.peekLast().right){
                        tmp = ad.pollLast();
                        System.out.printf("%d ",tmp.data);
                    }
                }
                else{
                    root = tmp;
                }
            }
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
        postOrder(root);
    }
}