class Solution {
    
    int dp[];
    
    int rec(int i,int []nums){
        if(i >= nums.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int max = 0;
        max = Math.max(nums[i] + rec(i+2,nums),rec(i+1,nums));
        return dp[i] = max;
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int sum = 0;
        for(int x:nums){
            sum+=x;
        }
        dp = new int[n];
        Arrays.fill(dp,-1);
        return rec(0,nums);
    }
}