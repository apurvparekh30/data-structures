// height of Binary Tree

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class GfG
{
    int height(Node node) 
    {
        // Your code here
        if(node == null)
            return 0;
        return Math.max(height(node.left) + 1,height(node.right)+1);
    }   
}