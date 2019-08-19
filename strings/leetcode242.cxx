class Solution {
public:
    bool isAnagram(string s, string t) {
        map<char,int> charCount;
        for(char c:s)
            charCount[c]++;
        for(char c:t) {
            charCount[c]--;
            if(charCount[c] < 0)
                return false;
        }
            
        for(auto& p:charCount){
            if(p.second != 0)
                return false;
        }
        return true;
    }
};
