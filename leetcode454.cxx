class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        unordered_map<int,int> umap;
        for(auto& aa:A)
            for(auto& bb:B)
                umap[aa+bb]++;
        int count = 0;
        for(auto& u:C)
            for(auto& v:D)
                count += umap[0-u-v];
        return count;
    }
};
