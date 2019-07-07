class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.addLast(c);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                char curr = stack.getLast();
                if(c==')'){
                    if(curr=='(')
                        stack.removeLast();
                    else
                        return false;
                }
                else if(c=='}') {
                    if(curr=='{')
                        stack.removeLast();
                    else 
                        return false;
                }
                else {
                    if(curr=='[')
                        stack.removeLast();
                    else 
                        return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}