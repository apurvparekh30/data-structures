class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0)
            return 0;
        int []maxLeft = new int[n];
        int []maxRight = new int[n];
        maxLeft[0] = 0;
        for(int i=1;i<n;i++){
            maxLeft[i] = Math.max(height[i-1],maxLeft[i-1]);
        }
        maxRight[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            maxRight[i] = Math.max(height[i+1],maxRight[i+1]);
        }
        int water = 0;
        for(int i=1;i<n-1;i++){
            int can = Math.min(maxLeft[i],maxRight[i]);
            water = water + Math.max(0,can - height[i]);
        }
        return water;
    }
}