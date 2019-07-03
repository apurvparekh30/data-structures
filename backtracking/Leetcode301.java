class Solution {
    Set<String> ret;
    
    public void rec(int i,String curr,int open,int close,int left,String s){
        if(i==s.length() && open==0 && close==0 && left==0){
            ret.add(curr);
        }
        if(i >= s.length()) 
            return;
        char c = s.charAt(i);
        if(c!='(' && c!=')')
            rec(i+1,curr+c,open,close,left,s);
        if(c=='('){
            if(open > 0){
                rec(i+1,curr,open-1,close,left,s); // ignore opening
            }
            rec(i+1,curr+"(",open,close,left+1,s); // take opening
        }
        else {
            if(close > 0){
                rec(i+1,curr,open,close-1,left,s); // ignore close
            }
            // take close
            if(left > 0){    // previously taken open
                rec(i+1,curr+")",open,close,left-1,s);
            }
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        ret = new HashSet<>();
        if(s.isEmpty()){
            ret.add("");
            return new ArrayList(ret);
        }
        int open = 0;
        int close = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(')
                open++;
            else if(c==')') {
                if(open > 0){
                    open--;
                }
                else {
                    close++;
                }
            }
        }
        rec(0,"",open,close,0,s);
        return new ArrayList<>(ret);
    }
}