class Solution {
    int n,m;
    
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};
    
    void dfs(int i,int j,char [][]board){
        for(int k=0;k<4;k++){
            int ii = i + dr[k];
            int jj = j + dc[k];
            if(ii<0 || ii>=n || jj<0 || jj>=m)
                continue;
            if(board[ii][jj]=='O'){
                board[ii][jj] = '-';
                dfs(ii,jj,board);
            }
                
        }
    }
    
    public void solve(char[][] board) {
        n = board.length;
        m = (n == 0) ? 0 : board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(board[i][j]=='O'){
                        board[i][j] = '-';
                        dfs(i,j,board);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                else if(board[i][j]=='-')
                    board[i][j] = 'O';
            }
        }
    }
}