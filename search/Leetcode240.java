class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0)
            return false;
        int m = matrix[0].length;
        
        int row = 0;
        int col = m-1;
        
        while(row >= 0 && col >=0 && row < n && col < m){
            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
}