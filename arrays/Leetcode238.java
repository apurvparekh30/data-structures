class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n==0)
            return new int[0];
        int []output = new int[n];
        output[0] = 1;
        for(int i=1;i<n;i++){
            output[i] = nums[i-1] * output[i-1];
        }
        int r = 1;
        for(int i=n-1;i>=0;i--){
            output[i] = output[i] * r;
            r = r * nums[i];
        }
        return output;
    }
}