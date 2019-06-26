class Solution {
    
    boolean containsDigit(String s){
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))
                return true;
        }
        return false;
    }
    
    int eval(int a,int b,char op){
        if(op=='+')
            return a + b;
        if(op=='-')
            return a - b;
        if(op=='*')
            return a * b;
        return a/b;
    }
    
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if(n==0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            String token = tokens[i];
            if(containsDigit(token)){
                stack.push(Integer.parseInt(token));
            }
            else {
                int a = stack.pop();
                int b = stack.pop();
                int res = eval(b,a,token.charAt(0));
                stack.push(res);
            }
        }
        return stack.peek();
    }
}