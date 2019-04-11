import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();

    static class Node {
        int data;
        Node left,right;
        int height;
        Node(int data){
            this.data = data;
            this.height = 1;
        }
    }

    static int height(Node r){
        if(r==null)
            return 0;
        return r.height;
    }

    static int balance(Node r){
        return height(r.left) - height(r.right);
    }

    static Node rightrotate(Node root){
        Node y = root.left;
        Node T = y.right;

        y.right = root;
        root.left = T;

        root.height = Math.max(height(root.left),height(root.right)) + 1;
        y.height = Math.max(height(y.left),height(y.right))+1;

        return y;
    }

    static Node leftRotate(Node root){
        Node y = root.right;
        Node T = y.left;

        y.left = root;
        root.right = T;

        root.height = Math.max(height(root.left),height(root.right)) + 1;
        y.height = Math.max(height(y.left),height(y.right))+1;

        return y;
    }

    static Node insert(Node root,int data){

        // BST insert
        if(root==null){
            return new Node(data);
        }
        if(data < root.data){
            root.left = insert(root.left,data);
        }
        else if(data > root.data){
            root.right = insert(root.right,data);
        }
        else
            return root;
        
        // update height    
        root.height = Math.max(height(root.left),height(root.right)) + 1;
    
        // get balance factor

        int balance = balance(root);
        if(balance > 1 && data < root.left.data){
            return rightrotate(root);
        }
        if(balance < -1 && data > root.right.data){
            return rightrotate(root);
        }
        if(balance > 1 && data > root.left.data){
            root.left = leftRotate(root.left);
            return rightrotate(root);
        }
        if(balance < -1 && data < root.right.data){
            root.right = rightrotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root,fs.nextInt());
        root = insert(root,fs.nextInt());
        root = insert(root,fs.nextInt());
        root = insert(root,fs.nextInt());        
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
    
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}