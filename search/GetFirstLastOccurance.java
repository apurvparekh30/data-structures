class Solution {
    
    public int binarySearch(int low,int high,int []nums,int target,boolean left){
        if(low > high)
            return -1;
        if(low == high){
            return (nums[low]==target ? low : -1); 
        }
        int mid = low + (high - low)/2;
        if(nums[mid] < target){
            return binarySearch(mid+1,high,nums,target,left);
        }
        else if(nums[mid] > target) {
            return binarySearch(low,mid-1,nums,target,left);
        }
        else if(left){
            return binarySearch(low,mid,nums,target,left);
        }
        else if(nums[mid+1]==target){
            return binarySearch(mid+1,high,nums,target,left);
        }
        return mid;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1,-1};
        if(nums.length==0)
            return ans;
        ans[0] = binarySearch(0,nums.length-1,nums,target,true);
        if(ans[0]==-1)
            return ans;
        ans[1] = binarySearch(0,nums.length-1,nums,target,false);
        return ans;
    }
}