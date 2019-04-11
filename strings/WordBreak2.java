import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static int n;
    static HashSet<String> hs;
    static String word;
    static TreeSet<String> ans;

    static void rec(int i, String s){
        if(i==word.length()){
            s = s.substring(0, s.length()-1) + ")";
            ans.add(s);
            return;
        }
        for(int j=i+1;j<=word.length();j++){
            if(hs.contains(word.substring(i,j))){
                rec(j,s+word.substring(i,j)+" ");
            }
        }
    }
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            hs = new HashSet<>();
            ans = new TreeSet<>();

            n = fs.nextInt();
            for(int i=0;i<n;i++)
                hs.add(fs.next());
            word = fs.next();
            rec(0,"(");
            if(!hs.isEmpty()){
                for(String s:ans){
                    System.out.print(s);
                }
                System.out.println();
            }
            else
                System.out.println("(Empty)");
                
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