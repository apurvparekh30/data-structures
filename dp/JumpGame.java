class Solution {
    
    Boolean []dp;
    boolean rec(int i,int []nums){
        if(i >= nums.length)
            return false;
        if(i == nums.length - 1)
            return true;
        if(dp[i]!=null)
            return dp[i];
        boolean ans = false;
        for(int jump = 1;jump <= nums[i];jump++){
            ans = ans | rec(i+jump,nums);
        }
        return dp[i] = ans;
    }
    public boolean canJump(int[] nums) {
        if(nums.length==0)
            return true;
        dp = new Boolean[nums.length];
        return rec(0,nums);
    }
}