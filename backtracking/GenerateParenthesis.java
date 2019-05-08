class Solution {
    List<String> perm = new ArrayList<>();
    void rec(int n,int m,String s){
        if(n==0 && m==0){
            perm.add(s);
            return;
        }
        if(n > 0){
            rec(n-1,m,s + "(");
        } 
        if(m > n){
            rec(n,m-1,s+")");
        }
          
    }
    public List<String> generateParenthesis(int n) {
        rec(n,n,"");
        return perm;
    }
}