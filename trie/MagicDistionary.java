class MagicDictionary {
    
    Node root;
    
    class Node {
        boolean isLeaf;
        Node []child = new Node[26];
    }

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Node();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s:dict){
            Node head = root;
            for(char c:s.toCharArray()) {
                if(head.child[c-'a']==null){
                    head.child[c-'a'] = new Node();
                }
                head = head.child[c-'a'];
            }
            head.isLeaf = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char []string = word.toCharArray();
        for(int i=0;i<string.length;i++){
            char old = string[i];
            for(char j ='a'; j <= 'z';j++){
                if(old==j)              
                    continue;
                string[i] = j;
                Node head = root;
                boolean found = true;
                for(char c:string){
                    if(head.child[c-'a']!=null){
                        head = head.child[c-'a'];
                    }
                    else {
                        found = false;
                        break;
                    }
                }
                if(found && head.isLeaf)
                    return true;
            }
            
            string[i] = old;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */