class Solution {
    
    boolean valid(int row,int col,char [][]board){
        char c = board[row][col];
        for(int i=0;i<9;i++){
            if((i!=col && board[row][i] == c) || (i != row && board[i][col] == c))
                return false;
        }
        int rstart = 3 * (row / 3);
        int cstart = 3 * (col / 3);
        
        for(int i=rstart;i<rstart+3;i++){
            for(int j=cstart; j<cstart+3;j++){
                if(i==row && j == col)
                    continue;
                if(board[i][j]==c){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    boolean rec(int row,int col,char [][]board){
        if(row >= 9){
            return true;
        }
        if(col >= 9){
            return rec(row+1,0,board);
        }
        if(Character.isDigit(board[row][col]) && !valid(row,col,board)){
            //System.out.println(row + " " + col);
            return false;
        }
            
        return rec(row,col+1,board);
    }
    
    public boolean isValidSudoku(char[][] board) {
        return rec(0,0,board);
    }
}