private static Node helper(Node root1,Node root2){
    if(root1==null&&root2==null){
        return null;
        
    }
    if(root1==null){
        return root2;
    }
    if(root2==null){
        return root1;
    }
    if(root1.data>root2.data){
        Node right=root2.right;
        root2.right=null;
        
        root1.left=helper(root1.left,root2);
        helper(root1,right);
    }
    else{
        Node left=root2.left;
        root2.left=null;
        root1.right=helper(root1.right,root2);
        helper(root1,left);
    }
    return root1;
    
}

private static void inorder(Node root){
    if(root==null){
        return ;
    }
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
}
public static void merge(Node root1 , Node root2)
     {
        helper(root1,root2);
        inorder(root1);
     }