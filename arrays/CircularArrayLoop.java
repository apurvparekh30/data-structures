class Solution {
    
    int getIndex(int i,int []nums){
        int n = nums.length;
        int nextIndex = i + nums[i];
        return nextIndex < 0 ? ((nextIndex%n)+n)%n:(nextIndex%n);
    }
    
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 0)
                continue;
            int j = getIndex(i,nums);
            int k = getIndex(i,nums);
            if(nums[i] * nums[k] < 0)
                continue;
            k = getIndex(k,nums);
            while(nums[j] * nums[i] > 0 && nums[k] * nums[i] > 0){
                //System.out.println(j + " " + k);
                if(j == k){
                    if(getIndex(j,nums) == j)
                        break;
                    System.out.println(i);
                    return true;
                }
                j = getIndex(j,nums);
                k = getIndex(k,nums);
                if(nums[i] * nums[k] < 0)
                    break;
                k = getIndex(k,nums);
            }
        }
        return false;
    }
}