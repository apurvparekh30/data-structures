class Solution {

    static int []dr = {1,0,-1,0};
    static int []dc = {0,-1,0,1};
    static int n,m;

    static void dfs(int i,int j,char [][]grid){
        for(int k=0;k<4;k++){
            int ni = i + dr[k];
            int nj = j + dc[k];
            if(ni < 0 || ni >= n || nj < 0 || nj >= m)
                continue;
            if(grid[ni][nj]=='0')
                continue;
            grid[ni][nj] = '0';
            dfs(ni,nj,grid);
        }
    }

    public int numIslands(char[][] grid) {
        int cc = 0;
        n = grid.length;
        
        m = (n==0) ? 0 : grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    cc++;
                    dfs(i,j,grid);
                }
            }
        }
        return cc;
    }
   
}
