class Solution {
    
    Boolean dp[][];
    
    boolean rec(int i,int sum,int target,int []nums){
        if(sum==target){
            return true;
        }
        if(i >= nums.length){
            return false;
        }
        if(dp[i][sum]!=null){
            return dp[i][sum];
        }
        boolean ans = false;
        if(sum + nums[i] <= target){
            ans = rec(i+1,sum+nums[i],target,nums);
        }
        if(ans == true){
            return dp[i][sum] = ans;
        }
        ans = rec(i+1,sum,target,nums);
        return dp[i][sum] = ans;
    } 
    
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n==0)
            return true;
        int target = 0;
        for(int x:nums){
            target += x;
        }
        if(target % 2 > 0)
            return false;
        target = target / 2;
        dp = new Boolean[n][target+1];
        return rec(0,0,target,nums);
    }
}