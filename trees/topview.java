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
     * 
     * class Node int data; Node left; Node right;
     */
    static void func(Node root,int col,int level,TreeMap<Integer,Integer> hm,TreeMap<Integer,Integer> lvl){
        if(root==null)
            return;
        if(hm.containsKey(col)){
            if(lvl.get(col) >= level){
                hm.put(col,root.data);
            }
        }
        else{
            hm.put(col,root.data);
            lvl.put(col,level);
        }
        func(root.left,col-1,level+1,hm,lvl);
        func(root.right,col+1,level+1,hm,lvl);
    }   

    static class MyNode{
        Node root;
        int col;
        MyNode(Node curr,int col){
            this.root = curr;
            this.col = col;
        }
    }

    static void bfs(Node root,TreeMap<Integer,Integer> hm){
        ArrayDeque<MyNode> ad = new ArrayDeque<>();
        ad.addLast(new MyNode(root, 0));
        while(!ad.isEmpty()){
            MyNode curr = ad.pollFirst();
            root = curr.root;
            int col = curr.col;
            if(!hm.containsKey(col)){
                hm.put(col,root.data);
            }
            if(root.left!=null){
                ad.addLast(new MyNode(root.left,col-1));
            }
            if(root.right!=null){
                ad.addLast(new MyNode(root.right,col+1));
            }
        }
    }

    public static void topView(Node root) {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        //func(root,0,0,tm,new TreeMap<Integer,Integer>());
        bfs(root,tm);
        Set<Integer> hs = tm.keySet();
        for(int key:hs){
            System.out.print(tm.get(key) + " ");
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
        topView(root);
    }
}