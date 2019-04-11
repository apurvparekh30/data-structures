boolean check(Node root,int mn,int mx){
    if(root == null)
        return;
    if(root.data >=mn && root.data <=mx)
        return (check(root.left,mn,root.data) && check(root.right,root.data,mx);
    return false;
}

boolean checkBST(Node root) {
    return check(root.left,0,root.data) && check(root.right,root.data,100000)
}