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
    public static int treePathsSum(Tree root){
        return rec(root,0);
    }
    static int rec(Tree root,int val){
        if(root==null){
            return 0;
        }
        val = (val * 10) + root.data;
        if(root.left == null && root.right == null)
            return val;
        return rec(root.left,idx+1) + rec(root.right,idx+1);
    }
    
}