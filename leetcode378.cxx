class Solution {
public:
    
    int find(vector<vector<int>>& mat,int num){
        int count = 0;
        for(auto& v:mat){
            for(auto& no:v){
                if(no <= num)
                    count++;
            }
        }
        return count;
    }
    
    int kthSmallest(vector<vector<int>>& mat, int k) {
        int low = mat[0][0];
        int high = mat[mat.size()-1][mat.size()-1];
        
        while(low < high){
            int mid = low + (high - low) / 2;
            int count = find(mat,mid);
            if(count < k)
                low = mid + 1;
            else
                high = mid;
            
        }
        
        return low;
        
    }
};
