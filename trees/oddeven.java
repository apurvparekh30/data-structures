// solution to odd even level tree difference

import java.util.*;
import java.lang.Integer;
import java.io.*;
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Solution
{
	// driver function to test the above functions
    public static void main(String args[])
    {
		
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		//Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
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
			
			System.out.println(g.getLevelDiff(root));
         t--;
			
        }
    }
}
class GfG
{   /*You are required to complete this function*/
    int arr[] = new int[2];
    int getLevelDiff(Node root)
    {
        dfs(root,1);
        return arr[1] - arr[0];
    }
    void dfs(Node root,int e){
        if(root == null)
            return;
        arr[e]+=root.data;
        dfs(root.left,1-e);
        dfs(root.right,1-e);
    }
    
}