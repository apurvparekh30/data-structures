/*
struct node
{
    int data;
    node* left;
    node* right;
};

*/
void leftview(node *root) {
    if(root!=NULL) {
        
        leftview(root->left);
        cout<<root->data<<" ";
    }
    
}
void rightview(node *root) {
    if(root!=NULL) {
        cout<<root->data<<" ";
        rightview(root->right);
    }
    
}
void topView(node * root) {
   
    leftview(root->left);
    cout << root->data<<" ";
    rightview(root->right);
}
