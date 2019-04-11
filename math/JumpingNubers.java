// solution to Jumping Numbers

/*
// Another solution

 private static void solve(int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print("0 ");
        for (int i = 1; i <= 9; i++) {
            queue.add(i);
            while (!queue.isEmpty()) {
                int temp = queue.remove();
                if (temp > n) continue;
                System.out.print(temp + " ");
                int leftMost = temp % 10;
                if (leftMost > 0) queue.add(temp * 10 + (leftMost - 1));
                if (leftMost < 9) queue.add(temp * 10 + (leftMost + 1));
            }
        }
        System.out.println();
    } 
 */

import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static int x;
    static List<Integer> ls;

    static void rec(int len,String s){
        //System.out.println(s);
        if(len == s.length()){
            ls.add(Integer.parseInt(s));
            return;
        }
        char digit = s.charAt(s.length()-1);
        if(digit!='0'){
            char nextDigit = (char)((int)digit - 1);
            rec(len,s+nextDigit);
        }
        if(digit!='9'){
            char nextDigit = (char)((int)digit + 1);
            rec(len,s+nextDigit);
        }
    }

    static void generate(){
        for(int i=0;i<=9;i++){
            ls.add(i);
        }
        for(int len=2;len <= 9;len++){
            for(int start=1;start<=9;start++){
                String s = "" + (char)('0'+ start);
                //System.out.println(s); 
                rec(len,s);
            }
        }
    }

    public static void main(String[] args) {
        int cases = fs.nextInt();
        ls = new ArrayList<Integer>();
        generate();
        //System.out.println(ls);
        for(int tt=1;tt<=cases;tt++){
            x = fs.nextInt();
            StringBuilder sb = new StringBuilder();
            for(int xx:ls){
                if(xx > x)
                    break;
                sb.append(xx).append(' ');
            }
            System.out.println(sb);
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