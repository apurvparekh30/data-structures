class Solution {
    
    int happy(int n){
        int sum = 0;
        while(n != 0){
            int rem = n % 10;
            sum += (rem * rem);
            n = n / 10;
        }
        return  sum;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> done = new HashSet<>();
        done.add(n);
        while(true){
            n = happy(n);
            if(n==1)
                break;
            if(done.contains(n))
                return false;
            done.add(n);
        }
        return true;
    }
}