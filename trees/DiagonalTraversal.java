import java.util.*;
import java.util.Map.Entry;

//Tree node
class TreeNode {
    int data; // node data
    TreeNode left, right; // left and right child's reference
    // Tree node constructor

    TreeNode(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            TreeNode root = null;
            if (n == 1) {
                int a = sc.nextInt();
                System.out.println(a);
                continue;
            } else {
                while (n-- > 0) {
                    int n1 = Integer.parseInt(sc.next());
                    int n2 = Integer.parseInt(sc.next());
                    char lr = sc.next().charAt(0);
                    if (root == null) {
                        root = new TreeNode(n1);
                        switch (lr) {
                        case 'L':
                            root.left = new TreeNode(n2);
                            break;
                        case 'R':
                            root.right = new TreeNode(n2);
                            break;
                        }
                    } else {
                        insert(root, n1, n2, lr);
                    }
                }
            }
            GfG tree = new GfG();
            tree.diagonalPrint(root);
            System.out.println();

        }
    }

    public static void insert(TreeNode root, int n1, int n2, char lr) {
        if (root == null)
            return;
        if (root.data == n1) {
            switch (lr) {
            case 'L':
                root.left = new TreeNode(n2);
                break;
            case 'R':
                root.right = new TreeNode(n2);
                break;
            }
        } else {
            insert(root.left, n1, n2, lr);
            insert(root.right, n1, n2, lr);
        }
    }
}

class GfG {

    class state {
        TreeNode v;
        int c;
        state(TreeNode v,int c){
            this.v = v;
            this.c = c;
        }
    }
    Map<Integer,ArrayList<TreeNode>> map;
    public void diagonalPrint(TreeNode root) {
        // add your code here.
        map = new TreeMap<>(Comparator.reverseOrder());
        Queue<state> q = new ArrayDeque<>();
        q.offer(new state(root,0));
        while(!q.isEmpty()){
            state curr = q.poll();
            TreeNode v = curr.v;
            int c = curr.c;
            if(!map.containsKey(c)){
                map.put(c,new ArrayList<>());
            }
            map.get(c).add(v);
            if(v.left != null){
                q.offer(new state(v.left,c-1));
            }
            if(v.right != null){
                q.offer(new state(v.right,c));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int key:map.keySet()){
            ArrayList<TreeNode> al = map.get(key);
            for(TreeNode v:al){
                sb.append(v.data).append(' ');
            }
        }
        System.out.print(sb);
    }
}