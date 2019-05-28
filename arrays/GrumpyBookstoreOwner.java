class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = grumpy.length;
        if(n == 0)
            return 0;
        int maxSat = 0;
        for(int i=0;i<n;i++){
            if(grumpy[i] == 0 || i < X)
                maxSat += customers[i];
        }
        int maxAns = maxSat;
        for(int i=1;i+(X-1) < n;i++){
            if(grumpy[i-1] == 1){
                maxSat -= customers[i-1];
            }
            if(grumpy[i+(X-1)] == 1){
                maxSat += customers[i+(X-1)];
            }
            maxAns = Math.max(maxSat,maxAns);
        }
        return maxAns;
    }
}