import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static char []s;
    static int n;
    static boolean memo[][];

    static boolean dp(int i,int j){
        if(i > j)
            return true;
        if(i==j)
            return true;
        if(memo[i][j]==false){
            return false;
        }
            
        boolean ans = false;
        if(s[i]==s[j])
            ans = dp(i+1,j-1);
        dp(i+1,j);
        dp(i,j-1);
        return memo[i][j]=ans;
    }   

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            s = fs.next().toCharArray();
            memo = new boolean[s.length][s.length];
            for(int i=0;i<s.length;i++)
                Arrays.fill(memo[i],true);
            dp(0,s.length-1);
            int max = s.length-1;
            for(int i=0;i<s.length;i++)
                for(int j=i+1;j<s.length;j++){
                    if(memo[i][j]){
                        int req = i+(s.length - 1 - j);
                        if(max > req)
                            max = req; 
                    }
                }
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