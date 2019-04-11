import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int k;
    static int n;
    static int []arr;
    static int memo[][];

    static int dp(int i,int k){
        if(k == 0)
            return 0;
        if(i >= n){
            return 0;
        }
        if(memo[i][k]!=-1)
            return memo[i][k];
        memo[i][k] = 0;
        int ans = 0;
        if(k%2==0){
            ans = Math.max(dp(i+1,k),dp(i+1,k-1)-arr[i]);
        }
        else{
            ans = Math.max(dp(i+1,k),dp(i+1,k-1)+arr[i]);               
        }
        return memo[i][k] = ans;
    }
    

    public static void main(String[] args) {
        int tc =fs.nextInt();
        while(tc -- > 0){
            k = fs.nextInt() * 2;
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            memo = new int[n][k+1];
            for(int i=0;i<n;i++)
                Arrays.fill(memo[i],-1);
            System.out.println(dp(0,k));
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