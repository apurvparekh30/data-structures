import java.util.*;
import java.lang.*;

class Node {
    char data;
    Node left, right;

    Node(char key) {
        data = key;
        left = right = null;
    }
}

class Solution {
    static class Res {
        int j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String str = "";
            str = sc.next();
            Res r = new Res();
            r.j = 0;
            Node root = null;
            root = insertString(root, str, r);

            GfG gfg = new GfG();
            boolean res = gfg.dupSub(root);
            if (res == true)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    public static Node insertString(Node root, String str, Res r) {
        if (r.j > str.length())
            return null;

        if (str.charAt(r.j) == '(')
            (r.j)++;

        if (str.charAt(r.j) != '(' && str.charAt(r.j) != ')') {
            char n = 0;
            n = str.charAt(r.j);

            (r.j)++;

            root = insert(root, n);

            if (str.charAt(r.j) == ')') {
                root.left = null;
                root.right = null;

                return root;
            }
        }

        if (str.charAt(r.j) == '(')
            (r.j)++;

        if (str.charAt(r.j) == ')') {
            root.left = null;
        } else {
            root.left = insertString(root.left, str, r);
        }

        while (str.charAt(r.j) == ')')
            (r.j)++;
        if (str.charAt(r.j) == '(')
            (r.j)++;

        if (str.charAt(r.j) == ')') {
            root.right = null;
            (r.j)++;
        } else {
            root.right = insertString(root.right, str, r);
        }

        return root;
    }

    public static Node insert(Node root, char n) {
        if (root == null) {
            root = new Node(n);
            return root;
        } else if (n < root.data)
            root = insert(root.left, n);

        else if (n > root.data)
            root = insert(root.right, n);

        return root;
    }

}

class GfG {

    static Map<String,Integer> map;

    static String dfs(Node root){
        if(root == null)
            return "";
        String ret = root.data + "";
        String left = dfs(root.left);
        String right = dfs(root.right);
        if(!left.isEmpty() || !right.isEmpty()){
            if(left.isEmpty())
                ret+=" ";
            else
                ret+=left;
            if(right.isEmpty())
                ret+=" ";
            else
                ret+=right;
            //System.out.println(ret+"|");
            if(map.containsKey(ret)){
                map.put(ret,map.get(ret)+1);
            }
            else{
                map.put(ret,1);
            }
        }
        return ret;
    }
    
    public static boolean dupSub(Node root) {
        map  = new HashMap<>();
        dfs(root);
        for(String key:map.keySet()){
            if(map.get(key) > 1){
                return true;
            }
                
        }
        return false;
    }
}