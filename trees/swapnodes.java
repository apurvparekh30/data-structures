import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Solution {

    /*
     * Complete the swapNodes function below.
     */

    static FastReader fs = new FastReader();

    static ArrayList<Integer> []depth;
    static Tree []tree;

    static void dfs(Tree node,int d){
        if(node == null)
            return;
        depth[d].add(node.data);
        dfs(node.left,d+1);
        dfs(node.right,d+1);
    }

    static void inorder(Tree t){
        if(t==null)
            return;
        inorder(t.left);
        System.out.print(t.data + " ");
        inorder(t.right);
    }

    public static void main(String[] args) {
        int n = fs.nextInt();
        tree = new Tree[n+1];
        depth = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            tree[i] = new Tree(i);
            depth[i] = new ArrayList<>();
        }
        for(int i=1;i<=n;i++){
            int l = fs.nextInt();
            int r = fs.nextInt();
            if(l!=-1)
                tree[i].left = tree[l];
            if(r!=-1)
                tree[i].right = tree[r];
        }
        dfs(tree[1],1);
        int t = fs.nextInt();
        for(int i=0;i<t;i++){
            int  k = fs.nextInt();
            int  h = k;
            while(h<=n){
                for(int d:depth[h]){
                    Tree temp = tree[d].left;
                    tree[d].left = tree[d].right;
                    tree[d].right = temp;
                }
                h = h + k;
            } 
            inorder(tree[1]);
            System.out.println();
        }
    }

    static class Tree {
        int data;
        Tree left,right;
        Tree(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
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
