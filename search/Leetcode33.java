class Solution {
    
    int binarySearch(int low,int high,int target,int []nums){
        if(low > high)
            return -1;
        if(low == high)
            return (nums[low] == target) ? low : -1;
        int mid = low + (high - low) / 2;
       
        if(nums[mid]==target)
            return mid;
        if(nums[low] <= nums[mid]){
            if(target >= nums[low] && target < nums[mid])
                return binarySearch(low,mid-1,target,nums);
            return binarySearch(mid+1,high,target,nums);
        }
        if(target > nums[mid] && target <= nums[high])
            return binarySearch(mid+1,high,target,nums);
        return binarySearch(low,mid-1,target,nums);
        
    }
    
    public int search(int[] nums, int target) {
        return binarySearch(0,nums.length-1,target,nums);
    }
}