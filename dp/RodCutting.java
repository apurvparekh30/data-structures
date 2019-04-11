// Knapsack with Duplicate Items 

import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static int n;
    static int []c;
    static int [][]memo;

    static int rec(int i,int w){
        if(i >= n)
            return 0;
        if(memo[i][w] != -1)
            return memo[i][w];
        memo[i][w] = 0;
        int ans = 0;
        if((w+i+1) <= n){
            ans = Math.max(ans,c[i] + rec(i,w+i+1));
        }
        ans = Math.max(ans,rec(i+1,w));
        return memo[i][w] = ans;
    }
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            c = new int [n];
            memo = new int[n][n+1];
            for(int i=0;i<n;i++)
                Arrays.fill(memo[i],-1);
            for(int i=0;i<n;i++)
                c[i] = fs.nextInt();
            System.out.println(rec(0,0));
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