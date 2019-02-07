//Remove â€œbâ€ and â€œacâ€ from a given string 

import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static char []arr;

    public static void main(String[] args) {
        int cases  = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            arr = fs.next().toCharArray();
            for(int i=0;i<arr.length;i++){
                if(arr[i] == 'b')
                    arr[i] = '.';
                if(arr[i]== 'c'){
                    if(i>0 && arr[i-1]=='a'){
                        arr[i] = '.';
                        arr[i-1] = '.';
                    }
                }
            }
            StringBuilder sb  = new StringBuilder();
            for(char c:arr){
                if(c == '.')
                    continue;
                sb.append(c);
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