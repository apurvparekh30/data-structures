import java.util.*;
import java.io.*;

class Solution{
    static FastReader fs = new FastReader();
    static int n;
    static int memo[];
    static int mod = 1000000007;

    static int dp(int i){
        if(i > n){
            return 0;
        }
        if(i==n)
            return 1;
        if(memo[i]!=-1){
            return memo[i];
        }
            
        memo[i] = 0;
        memo[i] = ((dp(i+1)%mod) + (dp(i+2)%mod))% mod;
        return memo[i];
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        memo = new int[100001];
        Arrays.fill(memo,-1);
        n = 100001;
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for(int i=3;i<n;i++){
            memo[i] = (memo[i-1]%mod + memo[i-2]%mod)%mod;
            //System.out.println(i + " " + memo[i]);
        }
           
        while(tc-- > 0){
            n = fs.nextInt();
            //System.out.println(n);
            System.out.println(memo[n]);
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
    
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}