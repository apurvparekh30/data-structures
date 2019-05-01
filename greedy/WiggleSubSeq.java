class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return nums.length;
        boolean flag;
        int i = 1;
        int n = nums.length;
        while(i < n && nums[i]==nums[i-1]){
            i++;
        }
        
        if(i==n)
            return 1;
        if(nums[i] > nums[i-1]){
            flag = false;
        }
        else {
            flag = true;
        }
        int prev = nums[i];
        i++;
        int count = 2;
        for(;i<n;i++){
            //System.out.println(i+ " " + prev + " " + flag);
            if(flag){
                if(nums[i] > prev){
                    count++;
                    prev = nums[i];
                    flag = !flag;
                }
                else {
                    if(nums[i] < prev){
                        prev = nums[i];
                    }
                }
            }
            else {
                if(nums[i] < prev){
                    count++;
                    prev = nums[i];
                    flag = !flag;
                }
                else {
                    if(nums[i] > prev){
                        prev = nums[i];
                    }
                } 
                    
            }
        }
        return count;
    }
}