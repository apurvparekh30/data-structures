import java.util.*;
import java.io.*;

class Tree {
    int data;
    Tree left, right;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class GfG
{
	static int sum = 0;
    static int []path = new int[100];
    public static int treePathsSum(Tree root){
        sum = 0;
        path = new int[100];
        rec(root,0);
        return sum/2;
    }
    static void rec(Tree root,int idx){
        if(root==null){
            calCulateSum(idx);
            return;
        }
        path[idx] = root.data;
        rec(root.left,idx+1);
        rec(root.right,idx+1);
    }
    static void calCulateSum(int n){
        int m = 1;
        for(int i=n-1;i>=0;i--){
            sum += (path[i] * m);
            m = m * 10;
        }
        //System.out.println(sum);
    }
}