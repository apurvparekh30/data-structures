class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        if(n == 0)
            return;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            reverse(matrix[i].begin(),matrix[i].end());
        }
    }
};
