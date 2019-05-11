class Solution {
    
    int rec(int low,int high,int []nums){
        //System.out.println(low + " " + high);
        if(low == high)
            return nums[low];
        int mid = low + (high - low)/2;
        if(nums[low] > nums[high]){
            if(nums[mid] <= nums[high]){
                return rec(low,mid,nums);
            }
            return rec(mid+1,high,nums);
        }
        return nums[low];
    }
    
    public int findMin(int[] nums) {
        if(nums.length==0)
            return 0;
        return rec(0,nums.length-1,nums);
    }
}