import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static char []string;
    static int memo[][];
    static int n;

    static int dp(int i,int j){
        if(i == j)
            return 1;
        if(i > j)
            return 1;
       // System.out.println(i + " " + j);
        if(memo[i][j] != -1)
            return memo[i][j];
        int ans = 0;
        if(string[i] == string[j]){
            ans = dp(i+1,j-1);
        }
        dp(i+1,j);
        dp(i,j-1);
        return memo[i][j] = ans;
    }
    public static void main(String[] args) {
        int tc =fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            memo = new int [n][n];
            for(int i=0;i<n;i++)
                Arrays.fill(memo[i],-1);
            string = fs.next().toCharArray();
            dp(0,string.length-1);
            int count = 0;
            for(int i=0;i<string.length;i++)
                for(int j=0;j<string.length;j++)
                    if(memo[i][j]==1)
                        count++;
            /* for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(memo[i][j] + " ");
                }
                System.out.println();
            } */
            System.out.println(count);
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