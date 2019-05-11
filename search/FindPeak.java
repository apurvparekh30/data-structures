class Solution {
    
    int binarySearch(int l,int r,int []nums){
        if(l==r)
            return l;
        int mid = l + (r - l) / 2;
        if(nums[mid] < nums[mid+1]){
            return binarySearch(mid+1,r,nums);
        }
        return binarySearch(l,mid,nums);
    }
    
    public int findPeakElement(int[] nums) {
        return binarySearch(0,nums.length-1,nums);
    }
}