import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static char[]a,b;
    static int oo = 987654321;
    static int [][]memo;

    static int rec(int i,int j){
        if(i == a.length && j == b.length)
            return 0;
        if(i == a.length){
            return b.length - j;
        }
        if(j == b.length){
            return a.length - i;
        }
        if(memo[i][j]!=-1)
            return memo[i][j];
        memo[i][j] = 0;
        int ans = oo;
        if(a[i] == b[j]){
            ans = Math.min(ans,rec(i+1,j+1));
        }
        ans = Math.min(ans,1+rec(i,j+1)); // insert
        ans = Math.min(ans,1+rec(i+1,j+1)); // replace
        ans = Math.min(ans,1+rec(i+1,j));  //remove from a;
        return memo[i][j] = ans;
    }

    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            fs.nextInt();
            fs.nextInt();
            a = fs.next().toCharArray();
            b = fs.next().toCharArray();
            memo = new int[a.length][b.length];
            for(int i=0;i<a.length;i++)
                Arrays.fill(memo[i],-1);
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