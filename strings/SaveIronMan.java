
// Solution to Save Ironman

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();

    public static void main(String[] args) {
        // code
        int cases = fs.nextInt();
        for (int tt = 1; tt <= cases; tt++) {
            StringBuilder sb = new StringBuilder();
            char[] str = fs.nextLine().toCharArray();
            for (char c : str) {
                if (Character.isDigit(c)){
                    sb.append(c);
                }        
                else if(Character.isLetter(c)){
                    sb.append(Character.toLowerCase(c));
                }
            }
            //System.out.println(sb);
            //System.out.println();
            //System.out.println(sb.reverse());
            String a = sb.toString();
            String b = sb.reverse().toString();
            //System.out.println(temp );
            //System.out.println(sb);
            if (a.equals(b))
                System.out.println("YES");
            else
                System.out.println("NO");
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