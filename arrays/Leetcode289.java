class Solution {
    
    int []dr = {1,1,0,-1,-1,-1,0,1};
    int []dc = {0,-1,-1,-1,0,1,1,1};
    
    
    
    public void gameOfLife(int[][] board) {
        int n = board.length;
        if(n == 0)
            return;
        int m = board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int cnt = 0;
                for(int k=0;k<8;k++){
                    int ni = i + dr[k];
                    int nj = j + dc[k];
                    if(ni<0 || ni>=n || nj<0 || nj>=m)
                        continue;
                    if(board[ni][nj]==2)
                        continue;
                    if(board[ni][nj]==1 || board[ni][nj]==-1)
                        cnt++;
                }
                //System.out.println(i + " " + j + " " + cnt);
                if(board[i][j]==0){
                    if(cnt == 3)
                        board[i][j] = 2;
                }
                else {
                    int val = 1;
                    if(cnt < 2){
                        val = -1;
                    }
                    else if(cnt > 3){
                        val = -1;
                    }
                    board[i][j] = val;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2){
                    board[i][j] = 1;
                }
                else if(board[i][j]==-1){
                    board[i][j] = 0;
                }
            }
        }
    }
}