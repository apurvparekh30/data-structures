import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void printINORDER(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        printINORDER(root.left);

        printINORDER(root.right);

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++)
                inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.printINORDER(root);
            System.out.println();

            T--;

        }
    }
}

class GfG {

    static int pe;
    
    static Node rec(int low,int high,int []in,int []post){
        int m = 0;
        int e = post[pe];
        Node root = new Node(e);

        for(int i=low;i<=high;i++){
            if(in[i] == e){
                m = i;
                break;
            }
        }
        if(m+1 <= high){
            pe--;
            root.right = rec(m+1,high,in,post);
        }
        if(low <= m - 1){
            pe--;
            root.left = rec(low,m-1,in,post);
        }
        return root;
    }
    
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        pe = n-1;
        return rec(0,n-1,in,post);
    }
}