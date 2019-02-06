// geeksforgeeks solution to Count of strings that can be formed using a, b and c under given constraints

import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static int n;
    static int [][][] memo;
    static int dfs(int n,int bc,int cc){
        if(bc < 0 || cc < 0)
            return 0;
        if(n == 0)
            return 1;
        if(bc == 0 && cc == 0)
            return 1;
        if(memo[n][bc][cc] != 0)
            return memo[n][bc][cc];
        return memo[n][bc][cc] = dfs(n-1,bc,cc) + dfs(n-1,bc-1,cc) + dfs(n-1,bc,cc-1);
    }

    public static void main(String[] args) {
       int cases = fs.nextInt();
       for(int tt=1;tt<=cases;tt++){
           n = fs.nextInt();
           memo = new int [n+1][2][3];
           /* for(int i=0;i<=n;i++)
            for(int j=0;j<2;j++)
                Arrays.fill(memo[i][j],-1); */
           System.out.println(dfs(n,1,2));
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