
// Solution to Amount of Water 

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int []arr;
    static int []left;
    static int []right;

    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1; tt<= cases; tt++){
            int n = fs.nextInt();
            arr = new int[n+1];
            left = new int[n+1];
            right = new int[n+1];
            for(int i=1;i<=n;i++){
                arr[i] = fs.nextInt();
                left[i] = Math.max(arr[i-1],left[i-1]);
            }

            for(int i=n-1;i>=0;i--){
                right[i] = Math.max(arr[i+1],right[i+1]);
            }
            int water = 0;
            for(int i = 1;i<=n;i++){
                water = water + Math.max(0,Math.min(left[i],right[i])-arr[i]);
            }
            System.out.println(water);

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