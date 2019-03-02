import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int k, n;
    static int[] arr;
    static int memo[][];

    static int dp(int i, int k) {
        if (i >= n) {
            return arr[n - 1];
        }
        if (k == 1) {
            return arr[n - 1];
        }
        if (memo[i][k] != -1){
            //return memo[i][k];
        }
            
        memo[i][k] = 0;
        // ideally if arr[i] is returned then only we should substract
        int ans = Math.min(Math.max(arr[i], dp(i + 1, k - 1) - arr[i]), dp(i + 1, k));
        return memo[i][k] = ans;
    }

    

    /* static int dp(int frm, int k) {
        if (frm >= n - 1) {
            return sum(frm, n);
        }
        if (k == 1)
            return sum(frm, n);
        if (memo[frm][k] != -1)
            return memo[frm][k];
        memo[frm][k] = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = frm + 1; i < n; i++) {
            int tmp;
            tmp = Math.max(sum(frm, i), dp(i, k - 1));
            ans = Math.min(tmp, ans);
        }
        return memo[frm][k] = ans;
    }

    static int sum(int from, int to) {
        int total = 0;
        for (int i = from; i < to; i++)
            total += arr[i];
        return total;
    } */

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- > 0) {
            k = fs.nextInt();
            n = fs.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = fs.nextInt();
            
             for (int i = 1; i < n; i++) 
                arr[i] = arr[i] + arr[i - 1];
            
             System.out.println(Arrays.toString(arr));
            memo = new int[n][k + 1];
            for (int i = 0; i < n; i++)
                Arrays.fill(memo[i], -1);
            System.out.println(dp(0, k));
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