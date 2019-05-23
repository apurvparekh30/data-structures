class Solution {

    boolean[][] done;
    int n,m;
    
    int []dr = {1,0,-1,0};
    int []dc = {0,-1,0,1};
    int targetCost = 0;
    
    int rec(int i,int j,int [][]grid,int cost){
        //System.out.println(i + " "+ j + " " + cost);
        if(grid[i][j]==2){
            //System.out.println(cost);
            if(cost==targetCost+1)
                return 1;
            return 0;
        }
        int ans = 0;
        for(int k=0;k<4;k++){
            int ni = i + dr[k];
            int nj = j + dc[k];
            if(ni<0 || ni>=n || nj<0 || nj>=m)
                continue;
            if(done[ni][nj] || grid[ni][nj]==-1)
                continue;
            done[ni][nj] = true;
            ans = ans + rec(ni,nj,grid,cost+1);
            done[ni][nj] = false;
        }
        return ans;
    }
    
    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        if(n == 0)
            return 0;
        m = grid[0].length;
        int si = 0;
        int sj = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    si = i;
                    sj = j;
                }
                if(grid[i][j]==0)
                    targetCost++;
            }
        }
        done = new boolean[n][m];
        done[si][sj] = true;
        return rec(si,sj,grid,0);
    }
}