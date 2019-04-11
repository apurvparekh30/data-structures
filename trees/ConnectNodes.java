
// solution to Connect Nodes at Same Level
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right, nextRight;

    Node(int item) {
        data = item;
        left = right = nextRight = null;
    }
}

class BT_Connect_Adjacent_Node {
    void inorder(Node node) {
        if (node == null)
            return;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);

    }

    void printSpecial(Node root) {
        if (root == null)
            return;
        Node node = root;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.nextRight;
        }
        if (root.left != null)
            printSpecial(root.left);
        else
            printSpecial(root.right);

    }

    // driver function to test the above functions
    public static void main(String args[]) {

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BT_Connect_Adjacent_Node can = new BT_Connect_Adjacent_Node();
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
            g.connect(root);
            can.printSpecial(root);
            System.out.println();
            can.inorder(root);
            System.out.println();
            t--;

        }
    }
}

class GfG {

    static class temp {
        Node root;
        int height;

        temp(Node root, int height) {
            this.root = root;
            this.height = height;
        }
    }

    void connect(Node root) {
        Deque<temp> q = new ArrayDeque<>();
        q.add(new temp(root, 1));
        temp prev = null;
        while (!q.isEmpty()) {
            temp curr = q.poll();
            if (prev == null) {
                prev = curr;
            } else if (prev.height != curr.height) {
                prev = curr;
            } else {
                prev.root.nextRight = curr.root;
                prev = curr;
            }
            if (curr.root.left != null) {
                q.add(new temp(curr.root.left, curr.height + 1));
            }
            if (curr.root.right != null) {
                q.add(new temp(curr.root.right, curr.height + 1));
            }
        }
    }
}