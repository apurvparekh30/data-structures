class Solution {
    public int nthUglyNumber(int n) {
        int []ugly = new int[n];
        ugly[0] = 1;
        int factor1 = 2; int factor2 = 3; int factor3 = 5;
        int index1 = 1; int index2 = 1; int index3 = 1;
        
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor1,factor2),factor3);
            ugly[i] = min;
            if(min == factor1){
                factor1 = ugly[index1++] * 2;
            }
            if(min == factor2){
                factor2 = ugly[index2++] * 3;
            }
            if(min == factor3){
                factor3 = ugly[index3++] * 5;
            }
        }
        //System.out.println(Arrays.toString(ugly));
        return ugly[n-1];
    }
}