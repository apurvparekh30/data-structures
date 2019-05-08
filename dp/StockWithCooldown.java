class Solution {
    
    int [][]dp;
    
    int rec(int i,int hasStock,int []prices){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][hasStock]!=-1){
            return dp[i][hasStock];
        }
        int ans = 0;
        if(hasStock==1){
            ans = Math.max(rec(i+1,hasStock,prices),rec(i+2,1-hasStock,prices) + prices[i]);
        }
        else {
            ans = Math.max(rec(i+1,hasStock,prices),rec(i+1,1-hasStock,prices) - prices[i]);
        }
        return dp[i][hasStock] = ans;
    }
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int []r:dp){
            Arrays.fill(r,-1);
        }
        return rec(0,0,prices);
    }
}