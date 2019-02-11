
// solution to Construct Tree from Preorder Traversal

import java.util.Scanner;
import java.lang.Math;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] pre = new int[n];
            char[] preLN = new char[n];
            for (int i = 0; i < n; i++) {
                int b = sc.nextInt();
                pre[i] = b;
            }
            for (int i = 0; i < n; i++) {
                char c = sc.next().charAt(0);
                preLN[i] = c;
            }
            GFG obj = new GFG();
            Node root = obj.constructTree(n, pre, preLN);
            inorder(root);
            System.out.println();
        }
    }
}

class GFG {

    static class MyInt{
        int i;
        MyInt(int i){
            this.i = i;
        }
    }

    Node rec(MyInt i,Node root,int pre[], char preLN[]){
        if(i.i >= pre.length)
            return null;
        if(root == null){
            root = new Node(pre[i.i]);
        }
        if(preLN[i.i] == 'L'){
            i.i++;
            return root;
        }
        i.i++;
        root.left = rec(i,root.left,pre,preLN);
        root.right = rec(i,root.right,pre,preLN);
        return root;
    }

    Node constructTree(int n, int pre[], char preLN[]) {
        // Add your code here.
        Node root = rec(new MyInt(0),null,pre,preLN);
        return root;
    }
}