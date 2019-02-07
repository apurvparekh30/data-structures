import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GfG {

    static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static Node helper(Node r1, Node r2) {
        if (r1 == null && r2 == null)
            return null;
        if (r1 == null)
            return r2;
        if (r2 == null)
            return r1;
        if (r1.data > r2.data) {
            Node right = r2.right;
            r2.right = null;
            r1.left = helper(r1.left, r2);
            r1 = helper(r1,right);
        } else {
            Node left = r2.left;
            r2.left = null;
            r1.right = helper(r1.right, r2);
            r1 = helper(r1,left);
        }
        return r1;
    }

    public static void merge(Node root1, Node root2) {
        // add code here.

        helper(root1, root2);
        inorder(root1);
    }
}