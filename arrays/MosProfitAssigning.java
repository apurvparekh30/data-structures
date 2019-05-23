class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int n = difficulty.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int curr = map.getOrDefault(difficulty[i],0);
            if(curr < profit[i])
                map.put(difficulty[i],profit[i]);
        }
        Arrays.sort(difficulty);
        Arrays.sort(worker);
        int i = 0;
        int total = 0;
        int best = 0;
        for(int skill:worker){
            while(i < n && difficulty[i] <= skill){
                best = Math.max(best,map.get(difficulty[i]));
                i++;
            }
            total = total + best;
        }
        return total;
    }
}