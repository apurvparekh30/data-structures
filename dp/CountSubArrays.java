import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int n;
    static int k;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            k = fs.nextInt();
            int count = 0;
            int lastGreaterIndex = -1;
            for(int i=0;i<n;i++){
                int no = fs.nextInt();
                if(no > k){
                    count+=(i-lastGreaterIndex) * (n-i);
                    lastGreaterIndex = i;
                }
            }
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