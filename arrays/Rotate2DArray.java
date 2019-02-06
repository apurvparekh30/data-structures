import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static int n;
    static int [][]a;
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt = 1; tt <= cases; tt++){
            n = fs.nextInt();
            a = new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    a[i][j] = fs.nextInt();

                    
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
                //System.out.println(Arrays.toString(a[i]));
            }

        
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                for(int j=n-1;j>=0;j--){
                    sb.append(a[i][j]).append(' ');
                }
            }
            System.out.println(sb);
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