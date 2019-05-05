class Solution {
    
    boolean [][] done;
    int n,m;
    
    int []dr = {1,0,-1,0};
    int []dc = {0,-1,0,1};
    
    public boolean rec(int i,int j,int k,char []word,char [][]board){
        //System.out.println(i+" " +j);
        if(k==word.length)
            return true;
        for(int id=0;id<4;id++){
            int ii = i + dr[id];
            int jj = j + dc[id];
            if(ii<0 || ii>=n || jj<0 || jj>=m)
                continue;
            if(done[ii][jj])
                continue;
            //System.out.println(ii + " " + jj + " " +board[ii][jj] + " " +word[k]);
            if(board[ii][jj]==word[k]){
                done[ii][jj] = true;
                if(rec(ii,jj,k+1,word,board))
                    return true;
                done[ii][jj] = false;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        if(word.length()==0)
            return false;
        n = board.length;
        m = board[0].length;
        done = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    done[i][j] = true;
                    if(rec(i,j,1,word.toCharArray(),board)){
                        return true;
                    }
                    done[i][j] = false; 
                }
            }
        }
        return false;
    }
}