public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] cost) {
        // write your code here
        if(cost == null || cost.length == 0)
            return 0;
        int n = cost.length;
        int m = cost[0].length;
        
        int min = 0;
        int secondMin = 0;
        int prevMinIndex = -1;
        
        for(int i=0;i<n;i++){
            int currMin = Integer.MAX_VALUE;
            int currSecondMin = Integer.MAX_VALUE;
            int currMinIndex = -1;
            for(int j=0;j<m;j++){
                cost[i][j] += (j==prevMinIndex ? secondMin : min);
                if(cost[i][j] < currMin){
                    currSecondMin = currMin;
                    currMin = cost[i][j];
                    currMinIndex = j;
                }
                else if(cost[i][j] < currSecondMin){
                    currSecondMin = cost[i][j];
                }
            }
            min = currMin;
            secondMin = currSecondMin;
            prevMinIndex = currMinIndex;
        }
        return min;
    }
}