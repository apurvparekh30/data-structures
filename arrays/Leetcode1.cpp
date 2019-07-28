class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> mp;
        vector<int> ret;
        for(int i=0;i<nums.size();i++){
            int num = nums[i];
            int complement = target - num;
            if(mp.find(complement) != mp.end()){
                ret.push_back(mp[complement]);
                ret.push_back(i);
                break;
            }
            mp[num] = i;
        }
        return ret;
    }
};

