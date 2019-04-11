
// Finding the numbers

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int n;
    static int []arr;
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            n = 2 * n + 2;
            arr = new int[n];
            int xor = 0;
            for(int i=0;i<n;i++){
                arr[i] = fs.nextInt();
                xor = xor ^ arr[i];
            }
            //System.out.println(xor);
            int lastSet = xor & (-xor);
            int x = 0,y = 0;
            for(int i=0;i<n;i++){
                if((arr[i] & lastSet) > 0)
                    x = x ^ arr[i]; 
                else
                    y = y ^ arr[i];
            }
            if(x > y){
                int temp = x;
                x = y;
                y = temp;
            }
            System.out.println(x + " "+ y);
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