class Solution {
    
    public void swap(int []nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n==0) return;
        int j = 0;
        int k = n - 1;
        for(int i=0;i<=k;i++){
            if(nums[i]==0){
                swap(nums,j,i);
                j++;
            }
            if(nums[i]==2){
                swap(nums,k,i);
                k--;
                i--;
            }
            //System.out.println(Arrays.toString(nums));
        }
    }
}