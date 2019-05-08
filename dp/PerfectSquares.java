class Solution {
    int []dp;
    
    int rec(int n){
        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            min = Math.min(min,1 + rec(n-(i*i))); 
        }
        dp[n] = min;
        return dp[n];
    }
    
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n);
    }
}