class Trie {

    /** Initialize your data structure here. */
    
    Node root;
    
    class Node {
        Node child[] = new Node[26];
        boolean isLeaf;
    }
    
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    
    public void insert(String word) {
        Node head = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(head.child[c-'a']==null){
                head.child[c-'a'] = new Node();
            }
            head = head.child[c-'a'];
        }
        head.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node head = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(head.child[c-'a']==null)
                return false;
            head = head.child[c-'a'];
        }
        return head.isLeaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Node head = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(head.child[c-'a']==null)
                return false;
            head = head.child[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */