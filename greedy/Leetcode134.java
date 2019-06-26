class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int index = -1;
        int totalGas = 0;
        int totalCost = 0;
        int n = gas.length;
        for(int i=0;i<n;i++){
            totalGas += gas[i];
            totalCost += cost[i];
            tank = tank + gas[i];
            tank = tank - cost[i];
            if(tank >= 0){
                if(index==-1) index = i;
            }
            else {
                tank = 0;
                index = -1;
            }
        }
        if(totalGas >= totalCost){
            return index;
        }
        return -1;
    }
}