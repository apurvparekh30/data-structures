public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        int n = nums.length;
        
        List<String> ret = new ArrayList<>();
        if(n==0){
            int from = lower;
            int to = upper;
            StringBuilder sb = new StringBuilder();
            if(from==to){
                sb.append(from);
            }
            else {
                sb.append(from).append("->").append(to);
            }
            ret.add(sb.toString());
            return ret;
        }
        if(nums[0] > lower){
            int from = lower;
            int to = nums[0]-1;
            StringBuilder sb = new StringBuilder();
            if(from==to){
                sb.append(from);
            }
            else {
                sb.append(from).append("->").append(to);
            }
            ret.add(sb.toString());
        }
        
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1])
                continue;
            if(nums[i] - 1 != nums[i-1]){
                int from = nums[i-1] + 1;
                int to = nums[i] - 1;
                StringBuilder sb = new StringBuilder();
                if(from == to){
                    sb.append(from);
                }
                else {
                    sb.append(from).append("->").append(to);
                }
                ret.add(sb.toString());
            }
        }
        if(nums[n-1] < upper){
            int from = nums[n-1]+1;
            int to = upper;
            StringBuilder sb = new StringBuilder();
            if(from == to){
                sb.append(from);
            }
            else {
                sb.append(from).append("->").append(to);
            }
            ret.add(sb.toString());
        }
        return ret;
    }
}