
// solultion to maximum area in histogram

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static FastReader fs = new FastReader();
    static int[] arr;
    static int n;

    public static void main(String[] args) {
        // code
        int cases = fs.nextInt();
        for (int tt = 1; tt <= cases; tt++) {
            n = fs.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = fs.nextInt();

            Stack<Integer> st = new Stack<>();
            int i = 0;
            long max_ans = 0;
            while (i < n) {
                if (st.isEmpty() || arr[st.peek()] <= arr[i]) {
                    st.push(i++);
                    continue;
                } else {
                    int t = st.peek();
                    st.pop();
                    long max = arr[t] * (st.isEmpty() ? i : i - st.peek() - 1);
                    if (max > max_ans)
                        max_ans = max;
                }
            }
            while (!st.isEmpty()) {
                int t = st.peek();
                st.pop();
                long max = arr[t] * (st.isEmpty() ? i : i - st.peek() - 1);
                if (max > max_ans)
                    max_ans = max;
            }
            System.out.println(max_ans);
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