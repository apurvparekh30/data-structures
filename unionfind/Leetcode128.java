class Solution {
    
    Map<Integer,Integer> map = new HashMap<>();
    
    int findParent(int i){
        if(!map.containsKey(i)){
            return i;
        }
        int parent =  findParent(map.get(i));
        map.put(i,parent);
        return parent;
    }
    
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        
        for(int i=0;i<n;i++){
            map.put(nums[i],nums[i]+1);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i] - 1))
                continue;
            int parent = findParent(nums[i]);
        
            //System.out.println(nums[i] + " " + parent);
            max = Math.max(parent - nums[i],max);
        }
        return max;
    }
}