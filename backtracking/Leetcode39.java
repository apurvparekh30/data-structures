class Solution {
    
    List<List<Integer>> ret = new ArrayList<>();
    
    public void rec(int i,int sum,int target,Deque<Integer> curr,int []nums){
        if(sum == target){
            ret.add(new ArrayList<>(curr));
            return;
        }
        if(i>=nums.length)
            return;
        if(sum + nums[i] <= target){
            curr.addLast(nums[i]);
            rec(i,sum+nums[i],target,curr,nums);
            curr.removeLast();
        }
        rec(i+1,sum,target,curr,nums);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0)
            return ret;
        rec(0,0,target,new ArrayDeque<>(),candidates);
        return ret;
    }
}