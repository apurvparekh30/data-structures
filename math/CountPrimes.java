class Solution {
    boolean nonPrime[];
    void generate(int n){
        for(int i=2;i*i<n;i++){
            if(!nonPrime[i]){
                for(int j=i*i;j<n;j=j+i){
                    nonPrime[j] = true;
                }
            }
        }
    }
    public int countPrimes(int n) {
        if(n==0 || n==1)
            return 0;
        nonPrime = new boolean[n];
        nonPrime[1] = true;
        generate(n);
        int count = 0;
        for(int i=1;i<n;i++){
            if(!nonPrime[i]){
                count++;
            }
        }
        return count;
    }
}