// X Total Shapes

import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static char [][]g;
    static int n,m;
    static boolean [][]vis;

    static int []dr = {1,0,-1,0};
    static int []dc = {0,-1,0,1};

    static void dfs(int i,int j){
        vis[i][j] = true;
        for(int k=0;k<4;k++){
            int ii = i + dr[k];
            int jj = j + dc[k];
            if(ii < 0 || ii>=n || jj<0 || jj>=m){
                continue;
            }
            if(g[ii][jj]=='O')
                continue;
            if(vis[ii][jj])
                continue;
            dfs(ii,jj);
        }
    }
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            m = fs.nextInt();
            g = new char[n][];
            for(int i=0;i<n;i++){
                g[i] = fs.next().toCharArray();
            }
            vis = new boolean[n][m];
            int count = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(vis[i][j])
                        continue;
                    if(g[i][j]=='X'){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
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