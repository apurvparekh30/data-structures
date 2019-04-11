import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static int []a,b;
    static FastReader fs = new FastReader();

    static class pair implements Comparable<pair>{
        int a,b;
        pair(int a,int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(pair other){
            if(this.a == other.a){
                return Integer.compare(b,other.b);
            }
            return Integer.compare(a,other.a);
        }
        @Override
        public String toString(){
            return a+" "+b+" ";
        }
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            pair []pairs = new pair[n];
            for(int i=0;i<n;i++){
                pairs[i] = new pair(fs.nextInt(),fs.nextInt());
            }
            Arrays.sort(pairs);
            if(pairs.length==1){
                System.out.println(pairs[0]);
                continue;
            }
            pair a = pairs[0];
            for(int i=1;i<pairs.length;i++){
                pair b = pairs[i];
                if(a.b < b.a){
                    System.out.print(a);
                    a = b;
                }
                else {
                    a = new pair(a.a,Math.max(a.b,b.b));
                }
            }
            System.out.print(a);
            System.out.println();
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