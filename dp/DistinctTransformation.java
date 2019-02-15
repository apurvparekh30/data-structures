import java.io.*;
import java.util.*;

class Solution{

    static FastReader fs = new FastReader();
    static String a,b;
    static long [][]memo;

    static long rec(int i,int j){
        if(j == b.length()){
            return 1;
        }
        if(i == a.length()){
            return 0;
        }
        if(memo[i][j]!=-1)
            return memo[i][j];
        memo[i][j] = 0;
        long ans = 0;
        if(a.charAt(i) == b.charAt(j)){
            ans = ans + rec(i+1,j+1);
        }
        ans = ans + rec(i+1,j);
        return memo[i][j] = ans;
    }


    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            a = fs.next();
            b = fs.next();
            memo = new long[a.length()][b.length()];
            for(int i=0;i<a.length();i++){
                Arrays.fill(memo[i],-1);
            }
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