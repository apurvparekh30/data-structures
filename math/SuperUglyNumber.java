class Solution {
    
    class Num implements Comparable<Num>{
        int val;
        int p;
        int idx;
        Num(int val,int p,int idx){
            this.val = val;
            this.p = p;
            this.idx = idx;
        }
        @Override
        public int compareTo(Num other){
            return Integer.compare(this.val,other.val);
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        Queue<Num> pq = new PriorityQueue<>();
        int k = primes.length;
        for(int i=0;i<k;i++){
            pq.add(new Num(primes[i],primes[i],i));
        }
        
        int []index = new int[k];
        
        int ugly [] = new int[n];
        ugly[0] = 1;
        for(int i=1;i<n;i++){
            Num min = pq.peek();
            ugly[i] = min.val;
            while(pq.peek().val == min.val){
                min = pq.poll();
                int val = min.p * ugly[++index[min.idx]];
                pq.offer(new Num(val,min.p,min.idx));
            }
        }
        return ugly[n-1];
    }
}