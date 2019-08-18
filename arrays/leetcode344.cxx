class Solution {
public:
    void reverseString(vector<char>& s) {
        int n = s.size();
        int j = n - 1;
        int i = 0;
        while(i <= j){
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
};
