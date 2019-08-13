class Solution {
public:
    unordered_map<int,int> mp;

    int dp(int num) {
        if(num == 0 || num == 1)
            return 1;
        if(mp.find(num)!=mp.end())
            return mp[num];
        int ans = 0;
        for(int i=0;i<num;i++) {
            ans += dp(i) * dp(num-i);
        }
        mp[num] = ans;
    }

    int numTrees(int n) {
        return dp(num);
    }
}    
