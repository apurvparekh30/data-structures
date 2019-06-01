class Solution {
    
    List<List<Integer>> list;
    int n;
    boolean []done;
    
    void rec(int i,int []nums,Integer []perm){
        
        if(i==n){
            List<Integer> temp = new ArrayList<>();
            for(int ii:perm){
                temp.add(ii);
            }
            list.add(temp);
            return;
        }
        for(int k=0;k<n;k++){
            if(done[k])
                continue;
            done[k] = true;
            perm[i] = nums[k];
            rec(i+1,nums,perm);
            done[k] = false;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        if(n == 0)
            return new ArrayList<>();
        list = new ArrayList<>();
        done = new boolean[n];
        rec(0,nums,new Integer[n]);
        return list;
    }
}