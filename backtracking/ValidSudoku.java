import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int[][] g;

    static boolean valid(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (i == row)
                continue;
            /* if(row==3 && col==0)
                System.out.println(g[i][col]); */
            if (g[i][col] == val)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (i == col)
                continue;
            if (g[row][i] == val)
                return false;
        }
        int ridx = (row / 3) * 3;
        int cidx = (col / 3) * 3;
        for (int i = ridx; i < (ridx + 3); i++) {
            for (int j = cidx; j < (cidx + 3); j++) {
                if (i == row && j == col)
                    continue;
                // System.out.println(i + " " + j);
                if (g[i][j] == val)
                    return false;
            }
        }
        return true;
    }

    static boolean rec(int row, int col) {
        if (row >= 9) {
            return true;
        }
        if (col >= 9) {
            return rec(row + 1, 0);
        }
        if (g[row][col] == 0) {
            for (int val = 1; val <= 9; val++) {
                if (valid(row, col, val)) {
                    g[row][col] = val;
                    if (rec(row, col + 1))
                        return true;
                    g[row][col] = 0;
                }
            }
        } else {
            return rec(row, col+1);
        }
        return false;
    }

    public static void main(String[] args) {
        int cases = fs.nextInt();
        for (int tt = 1; tt <= cases; tt++) {
            g = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    g[i][j] = fs.nextInt();
                }
            }
            if (rec(0, 0))
                System.out.println(1);
            else
                System.out.println(0);

            /* for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(g[i][j] + " ");
                }
                System.out.println();
            } */
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