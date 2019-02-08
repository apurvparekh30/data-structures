import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static HashSet<String> hs;
    static String word;
    static int n;
    static int memo[];

    static int rec(int i){
        if(i==word.length())
            return 1;
        if(memo[i]!=-1)
            return memo[i];
        for(int j=i+1;j<=word.length();j++){
            if(hs.contains(word.substring(i,j))){
                //System.out.println("hi");
                if(rec(j)==1){
                    return memo[i] = 1;
                }
            }
        }
        return memo[i] = 0;
    }
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            hs = new HashSet<>();
            n = fs.nextInt();
            for(int i=0;i<n;i++){
                hs.add(fs.next());
            }
            word = fs.next();
            memo = new int[word.length()];
            Arrays.fill(memo,-1);
            //System.out.println(hs);
            System.out.println(rec(0));
            //System.out.println(Arrays.toString(memo));
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