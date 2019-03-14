import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

class Delete_A_BST_Node {
    Node root;

    void insert(Node root, int key) {
        if (key < root.key) { // System.out.print(root.key);
            if (root.left != null)
                insert(root.left, key);
            else {
                root.left = new Node(key);
            }
            // root = root.left;
            // insert(root.left,key);
        } else if (key > root.key) {
            // System.out.print(root.key);
            if (root.right != null)
                insert(root.right, key);
            else {
                root.right = new Node(key);
            }
        }
    }

    void inorder(Node node) {
        if (node == null)
            return;
        else
            inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Delete_A_BST_Node tree = new Delete_A_BST_Node();
            // GfG g = new GfG();
            int a1 = sc.nextInt();
            Node root = new Node(a1);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                tree.insert(root, a);
            }
            int n1 = sc.nextInt();
            GfG g = new GfG();
            Node s = g.deleteNode(root, n1);
            tree.inorder(s);
            System.out.println();
            t--;
        }
    }
}

class GfG {
    Node deleteNode(Node root, int key) {
        // Your code here
        if(root==null)
            return root;
        if(root.key < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.key > key){
            root.left = deleteNode(root.left, key);
        }
        else {
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null) {
                return root.left;
            }
            Node temp = root.right;
            while(temp.left!=null){
                temp = temp.left;
            }
            root.key = temp.key;
            root.right = deleteNode(root.right, temp.key);
        }
        return root;
    }
}