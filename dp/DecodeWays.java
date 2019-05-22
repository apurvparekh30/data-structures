class Solution {
    
    int []dp;
    
    int rec(int i,String s){
        if(i >= s.length()){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans = 0;
        int number = 0;
        for(int size = 0; size < 2; size++){
            if(i + size < s.length()) {
                number = number * 10 + s.charAt(i+size) - '0';
                //System.out.println(number);
                if(number > 0 && number <= 26){
                    ans += rec(i + size + 1,s);
                }
                if(number == 0)
                    break;
            }
        }
        return dp[i] = ans;        
    }
    
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return rec(0,s);
    }
}