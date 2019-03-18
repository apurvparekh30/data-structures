
// Java Program to print Bottom View of Binary Tree
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
import java.util.*;

// Tree node class
class Node {
    int data; // data of the node
    int hd; // horizontal distance of the node
    Node left, right; // left and right references

    // Constructor of tree node
    public Node(int key) {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

class Solution {
    // driver function to test the above functions
    public static void main(String args[]) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // Node root=null;
        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                // cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }

            GfG g = new GfG();

            // g.leftView(root);
            g.bottomView(root);

            System.out.println();
            t--;
        }
    }
}

class GfG {
    Map<Integer,Integer> map;

    class state {
        Node node;
        int d;
        state(Node node,int d){
            this.node = node;
            this.d = d;
        }
    }
    public void bottomView(Node root) {
        // Your code here
        map = new TreeMap<>();
        Queue<state> q = new ArrayDeque<>();
        q.offer(new state(root,0));
        while(!q.isEmpty()){
            state curr = q.poll();
            map.put(curr.d,curr.node.data);
            if(curr.node.left!=null) {
            	q.offer(new state(curr.node.left,curr.d-1));
            }
            if(curr.node.right!=null){
            	q.offer(new state(curr.node.right,curr.d+1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int d:map.keySet()){
			sb.append(map.get(d)).append(' ');
        }
        System.out.print(sb);
    }
}
