class Solution {
    
    int [][]dp;
    
    int []dr = {1,0,-1,0};
    int []dc = {0,-1,0,1};
    
    int n,m;
    
    int rec(int i,int j,int [][]mat){
        if(dp[i][j]!=-1)
            return dp[i][j];
        int max = 0;
        for(int k=0;k<4;k++){
            int ni = i + dr[k];
            int nj = j + dc[k];
            if(ni<0 || ni>=n || nj<0 || nj>=m)
                continue;
            if(mat[ni][nj] <= mat[i][j])
                continue;
            max = Math.max(max,rec(ni,nj,mat));
        }
        return dp[i][j] = max + 1;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0)
            return 0;
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];
        for(int []r:dp)
            Arrays.fill(r,-1);
        int max = 0;
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(dp[i][j]==-1){
                    max = Math.max(max,rec(i,j,matrix));
                } 
            }
        return max;
    }
}