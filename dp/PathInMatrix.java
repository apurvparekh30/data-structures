// Path in Matrix

import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static int n;
    static int [][] mat;
    static int [][] memo;

    static int rec(int i,int j){
        if(i==n-1){
            return mat[i][j];
        }
        if(memo[i][j]!=-1)
            return memo[i][j];
        memo[i][j] = 0;
        if(j-1 >= 0)
            memo[i][j] = Math.max(memo[i][j],mat[i][j]+rec(i+1,j-1));
        if(j+1 < n)
            memo[i][j] = Math.max(memo[i][j],mat[i][j]+rec(i+1,j+1));
        memo[i][j] = Math.max(memo[i][j],mat[i][j] + rec(i+1,j));
        return memo[i][j];
    }
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            mat = new int[n][n];
            memo = new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    mat[i][j] = fs.nextInt();
            for(int i=0;i<n;i++){
                Arrays.fill(memo[i],-1);
            }
            int ans = -1;
            for(int i=0;i<n;i++)
                ans = Math.max(ans,rec(0,i));
            System.out.println(ans);
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