public static void postOrder(Node root) {
    if(root!=null){
        postOrder(root.left);
        postOrder(root.right);
        System.out.printf("%d ",root.data);
    }
}
