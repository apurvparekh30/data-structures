
// Longest valid Parentheses length

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static char []ch;
    public static void main(String[] args) {
        // code
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            ch = fs.next().toCharArray();
            Stack<Integer> st = new Stack<>();
            st.push(-1);
            int max = 0;
            for(int i=0;i<ch.length;i++){
                System.out.println(st + " " + max);
                char c = ch[i];
                if(c == '('){
                    st.push(i);
                }
                else{
                    st.pop();
                    if(!st.empty()){
                        max = Math.max(max,i-st.peek());
                    }
                    else{
                        st.push(i);
                    }
                }
            }
            System.out.println(st);
            System.out.println(max);
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