// Egg Dropping Puzzle 

import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int memo[][];
    static int n,h;

    static int rec(int r,int k){
        if(r == 1)
            return k;
        if(k <= 0)
            return 0;
        if(memo[r][k]!=-1){
            return memo[r][k];
        }
        memo[r][k] = 0;
        int ans = 987654321;
        for(int i=1;i<=k;i++){
            ans = Math.min(ans,1 + Math.max(rec(r-1,i-1),rec(r,k-i)));
            //System.out.println("r=" + r + " " + "i=" + i + " " + ans);
        }   
        
        return memo[r][k] = ans;
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++) {
            n = fs.nextInt();
            h = fs.nextInt();
            memo = new int[n+1][h+1];
            for(int i=0;i<=n;i++)
                Arrays.fill(memo[i],-1);
            
            System.out.println(rec(n,h));
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