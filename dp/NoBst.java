import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int n;
    static int []dp;
    public static void main(String[] args) {
        int cases = fs.nextInt();
        dp = new int[12];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i=4;i<=11;i++){
           for(int j=1;j<=i;j++){
               dp[i]+=dp[j-1] * dp[i-j];
           }
        }
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            System.out.println(dp[n]);
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