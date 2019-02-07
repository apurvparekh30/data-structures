import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    static FastReader fs = new FastReader();
    static char []arr;
    static int memo[][];
    static int rec(int i,int j){
        if(i>j)
            return 0;
        if(i==j)
            return 0;
        if(memo[i][j] != -1)
            return memo[i][j];
        if(arr[i] == arr[j])
            return rec(i+1,j-1);
        return memo[i][j] = 1 + Math.min(rec(i+1,j),rec(i,j-1));
    }
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt = 1;tt <= cases; tt++){
            arr = fs.next().toCharArray();
            memo = new int[arr.length][arr.length];
            for(int i=0;i<arr.length;i++)
                Arrays.fill(memo[i],-1);
            System.out.println(rec(0,arr.length-1));
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