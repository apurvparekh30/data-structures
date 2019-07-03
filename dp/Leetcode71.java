class Solution {
    
    int [][]dp;

    int rec(int i,int j,String word1,String word2){
        if(i==word1.length()){
            return word2.length() - j;
        }
        if(j==word2.length()){
            return word1.length() - i;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans = 987654321;
        if(word1.charAt(i)==word2.charAt(j)){
            ans = Math.min(ans,rec(i+1,j+1,word1,word2));
        }
        else {
            ans = Math.min(ans,1 + rec(i+1,j+1,word1,word2)); // replace
            ans = Math.min(ans,1 + rec(i,j+1,word1,word2)); // insert
            ans = Math.min(ans,1 + rec(i+1,j,word1,word2)); // delete
        }
        return dp[i][j] = ans;
    }
    
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];
        for(int []r:dp){
            Arrays.fill(r,-1);
        }
        return rec(0,0,word1,word2);
    }
}