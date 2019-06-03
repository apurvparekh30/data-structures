class Solution {
    List<List<Integer>> ret = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        if(n==0)
            return ret;
        for(int i=0;i<(1<<n);i++){
            List<Integer> sub = new LinkedList<>();
            for(int k=0;k<n;k++){
                if((i & (1 << k)) > 0){
                    sub.add(nums[k]);
                }
            }
            ret.add(sub);
        }
        return ret;
    }
}