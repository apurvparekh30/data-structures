class Solution {
public:
    
    static bool cmp(vector<int> a,vector<int> b){
        if(a[0] == b[0])
            return a[1] < b[1];
        return a[0] < b[0];
    }
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        std::sort(people.begin(),people.end(),cmp);
        vector<vector<int>> ret(people.size());
        vector<bool> occ(people.size(),false);
        
        for(vector<int> vec:people){
            int need = vec[1];
            for(int i=0;i<ret.size();i++){
                
                if(need <= 0 && !occ[i]) {
                    ret[i] = vec;
                    //cout << vec[0] << " " << vec[1] << " " << i << endl;
                    occ[i] = true;
                    break;
                }
                if(!occ[i] || ret[i][0] >= vec[0])
                    need--;
            }
        }
        return ret;
    }
};