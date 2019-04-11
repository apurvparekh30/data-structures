import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static int n;
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            //System.out.println(n);
            int sum = 0;
            for(int i=0;i<n-1;i++){
                sum = sum + fs.nextInt();
            }
            int num = (n * (n + 1)) / 2;
            //System.out.println(sum);
            num = num - sum;
            System.out.println(num);
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