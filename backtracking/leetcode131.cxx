class Solution {
public:
    
    bool isPalindrome(string s){
        for(int i = 0, j = s.length()-1; i < j ; i++,j--){
            if(s[i]!=s[j])
                return false;
        }
        return true;
    }
    
    vector<vector<string>> ret;
    
    void rec(int i,string s,vector<string>& v){
        if(i >= s.length()){
            ret.push_back(v);
            return;
        }
        v.push_back(s.substr(i,1));
        rec(i+1,s,v);
        v.pop_back();
        for(int step = 2;i + step <= s.length();step++){
            if(isPalindrome(s.substr(i,step))){
                v.push_back(s.substr(i,step));
                rec(i+step,s,v);
                v.pop_back();
            }
        }
    }
    
    vector<vector<string>> partition(string s) {
        vector<string> v;
        rec(0,s,v);
        return ret;
    }
};
