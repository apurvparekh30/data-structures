/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    int i = 0;
    
    TreeNode rec(int expected,String s){
        if(i >= s.length())
            return null;
        if(s.charAt(i)=='-'){
            int tmp = i;
            int cnt = 0;
            while(s.charAt(tmp)=='-'){
                cnt++;
                tmp++;
            }
            if(cnt!=expected)
                return null;
            i = tmp;
        }
        TreeNode newNode = null;
        if(Character.isDigit(s.charAt(i))) {
            int no = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))) {
                no = no * 10 + (s.charAt(i) - '0');
                i++;
            }
            newNode = new TreeNode(no);
            newNode.left = rec(expected+1,s);
            newNode.right = rec(expected+1,s);
        }
        return newNode;
    }
    
    public TreeNode recoverFromPreorder(String S) {
        return rec(0,S);
    }
}