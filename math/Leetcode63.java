class Solution {
    public int uniquePaths(int m, int n) {
        int k = (m-1) + (n-1);
        int [][]pascal = new int[k+1][k+1];
        for(int []r:pascal){
            Arrays.fill(r,1);
        }
        
        for(int row = 2;row < k+1; row ++){
            for(int col = 1;col < row ; col++){
                pascal[row][col] = pascal[row-1][col-1] + pascal[row-1][col];
            }
        }
        return pascal[k][m-1];
    }
}