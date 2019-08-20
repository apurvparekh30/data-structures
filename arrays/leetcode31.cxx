class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        if(nums.size() == 0)
            return;
        int i = nums.size() - 2;
        int x = 0;
        while(i >= 0){
            if(nums[i] < nums[i+1]){
                x = nums[i];
                break;
            }
            i--;
        }
        if(i == -1){
            sort(nums.begin(),nums.end());
            return;
        }
        int j = nums.size() - 1;
        while(j > i){
            if(nums[j] > x){
                nums[i] = nums[j];
                nums[j] = x;
                break;
            }
            j--;
        }
        sort(nums.begin() + i + 1,nums.end());
    }
};
