class Solution {
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        if(n == 0)
            return 0;
        int [][]dp;
        int up = 2 * 10000 + 1;
        dp = new int[n][up];
        int ans = 0;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int diff = A[i] - A[j];
                if(diff < 0)
                    diff += 10000;
                int len = 2;
                len = Math.max(len,1 + dp[j][diff]);
                if(ans < len)
                    ans = len;
                dp[i][diff] = Math.max(dp[i][diff],len);
            }
        }
        return ans;
    }
}