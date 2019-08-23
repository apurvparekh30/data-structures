class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,int> umap;
        
        int index = 0;
        
        vector<vector<string>> ret;
        
        for(string& s:strs){
            string copy = s;
            sort(copy.begin(),copy.end());
            if(umap.find(copy)==umap.end()){
                umap[copy] = index;
                ret.push_back(vector<string>());
                index++;
            }
            vector<string>& v = ret[umap[copy]];
            v.push_back(s);
        }
        
        return ret;
    }
};
