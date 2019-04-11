import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int n;
    static int []arr;
    static int []memo;
    static int oo = 987654321;

    static int rec(int i){
        if(i >= n-1)
            return 0;
        if(memo[i]!=-1)
            return memo[i];
        memo[i] = 0;
        int ans = oo;
        for(int j=1;j<=arr[i];j++){
            ans = Math.min(ans,1+rec(i+j));
        }
        return memo[i] = ans;
    }

    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = fs.nextInt();
            }
            memo = new int[n+1];
            Arrays.fill(memo,-1);
            int ans = rec(0);
            if(ans == oo)
                System.out.println("-1");
            else
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