import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Merge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Node fhead = null;
            Node shead = null;
            for (int i = 0; i < x; i++) {
                if (fhead == null)
                    fhead = new Node(sc.nextInt());
                else {
                    insert(fhead, sc.nextInt());
                }
            }
            for (int i = 0; i < y; i++) {
                if (shead == null)
                    shead = new Node(sc.nextInt());
                else {
                    insert(shead, sc.nextInt());
                }
            }
            GfG g = new GfG();
            g.merge(fhead, shead);
            System.out.println();
        }
    }

    public static Node insert(Node head, int a) {
        if (head == null)
            return new Node(a);
        if (head.data > a)
            head.left = insert(head.left, a);
        if (head.data < a)
            head.right = insert(head.right, a);
        return head;
    }
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left, right; Node(int d){ data=d; left=right=null; } }
 */
class GfG {

    static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }

    static Node helper(Node r1,Node r2){
        if(r1==null && r2==null)
            return null;
        if(r1==null)
            return r2;
        if(r2==null)
            return r1;
        if(r1.data > r2.data){
            Node right = r2.right;
            r2.right = null;
            r1.left = helper(r1.left,r2);
            r1 = helper(r1,right);
        }
        else {
            Node left = r2.left;
            r2.left = null;
            r1.right = helper(r1.right,r2);
            r1 = helper(r1,left);
        }
        return r1;
    }


    public static void merge(Node root1, Node root2) {
        helper(root1,root2);
        inorder(root1);
    }
}