class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int number = 0;
        for(int i=1;i<=n;i++){
            number ^= nums[i-1] ^ i;
        }
        return number;
    }
};
