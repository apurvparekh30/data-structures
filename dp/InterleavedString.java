import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static char []a,b,c;
    static boolean [][][] memo;

    static boolean dp(int i,int j,int k){
        if(i >= c.length)
            return true;
        if(memo[i][j][k]==false)
            return false;
        boolean ans = false;
        if(j < a.length && c[i] == a[j])
            ans|=dp(i+1,j+1,k);
        if(k < b.length && c[i] == b[k])
            ans|=dp(i+1,j,k+1);
        return memo[i][j][k] = ans;
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            a = fs.next().toCharArray();
            b = fs.next().toCharArray();
            c = fs.next().toCharArray();
            memo = new boolean[c.length+1][a.length+1][b.length+1];
            for(int i=0;i<=c.length;i++)
                for(int j=0;j<=a.length;j++)
                    Arrays.fill(memo[i][j],true);
            if(dp(0,0,0))
                System.out.println(1);
            else
                System.out.println(0);
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