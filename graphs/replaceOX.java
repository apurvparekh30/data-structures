import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};

    static boolean []vis;

    static char [][]g;
    static int n,m;

    static void dfs(int i,int j){
        vis[i*m+j] = true;
        g[i][j] = 'O';
        for(int k=0;k<4;k++){
            int ii = i + dr[k];
            int jj = j + dc[k];
            if(ii <= 0 || ii >= n-1 || jj <= 0 || jj >= m-1)
                continue;
            if(vis[ii*m+jj])
                continue;
            if(g[ii][jj]=='-'){
                dfs(ii,jj);
            }
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            m = fs.nextInt();
            vis = new boolean[n*m];
            g = new char[n][m];
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++){
                    g[i][j] = fs.next().charAt(0);
                    if(g[i][j]=='O')
                        g[i][j] = '-';
                }   
                    
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(g[i][j]=='-' && !vis[i*m + j]){
                        if(i==0 || i==n-1 || j==0 || j==m-1)
                            dfs(i,j);
                    }
                }
            }
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++){
                    char c = g[i][j];
                    if(g[i][j]=='-')
                        c = 'X';
                    sb.append(c).append(' ');
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