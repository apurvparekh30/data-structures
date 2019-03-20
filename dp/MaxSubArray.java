import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        int cases = fs.nextInt();
        for (int tt = 1; tt <= cases; tt++) {
            n = fs.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = fs.nextInt();
            int sum = arr[0];
            int curr = arr[0];
            for (int i = 1; i < n; i++) {
                curr = Math.max(arr[i], curr + arr[i]);
                sum = Math.max(sum, curr);
            }
            System.out.println(sum);
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