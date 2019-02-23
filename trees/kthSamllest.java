import java.io.*;
import java.util.ArrayDeque;
import java.util.Scanner;

class Node{
	int data;
	Node left, right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            Node fhead=null;
            for(int i = 0; i < n; i++)
			{
				if(fhead==null)
					fhead = new Node(sc.nextInt());
				else{
					insert(fhead,sc.nextInt());
				}
			}
			int k=sc.nextInt();
			gfg2 g=new gfg2();
			int ans=g.kthSmallest(fhead,k);
			System.out.println(ans);
        }
    }
    public static Node insert(Node head, int a){
		if(head==null)
			return new Node(a);
		if(head.data>=a)
			head.left=insert(head.left,a);
		if(head.data<a)
			head.right=insert(head.right,a);
		return head;
	}
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

class gfg2
{   
    static int ans = -1;
    static int c = 0;

    public static void inorder(Node root,int k){
        if(root == null || c>=k)
            return;
        inorder(root.left, k);
        c++;
        if(k==c){
            ans = root.data;
        }
        inorder(root.right, k);
    }



    public static int kthSmallest(Node root,int k)
    {
        c = 0;
        ans = - 1;
        inorder(root,k);
        return ans;
    }
}
