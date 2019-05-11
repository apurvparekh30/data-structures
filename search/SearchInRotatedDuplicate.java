class Solution {
    boolean rec(int low,int high,int target,int []nums){
        if(low > high){
            return false;
        }
        int mid = low + (high-low)/2;
        if(nums[mid]==target){
            return true;
        }
        if(nums[low]==nums[mid] && nums[mid]==nums[high]){
            return rec(low+1,high-1,target,nums);
        }
        else if(nums[mid] <= nums[high]){
            if(target > nums[mid] && target <= nums[high]){
                return rec(mid+1,high,target,nums);
            }
            return rec(low,mid-1,target,nums);
        }
        else {
            if(target >= nums[low] && target < nums[mid]){
                return rec(low,mid-1,target,nums);
            }
            return rec(mid+1,high,target,nums);
        }
    }
    public boolean search(int[] nums, int target) {
        return rec(0,nums.length-1,target,nums);
    }
}