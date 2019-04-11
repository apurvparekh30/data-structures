import java.util.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static Set<String> words;
    static int n,m;
    static int w;
    static char[][] g;
    static int[] dr = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static Set<String> found;
    static boolean visited[];

    static void dfs(int i,int j,String s){
        //System.out.println(s);
        if(words.contains(s)){
            found.add(s);
        }
        for(int k=0;k<8;k++){
            int ii = i + dr[k];
            int jj = j + dc[k];
            
            if(ii < 0 || ii >=n || jj<0 || jj>=m)
                continue;
            if(visited[ii*m+jj]){
                continue;
            }
            
            visited[ii*m+jj] = true;
            dfs(ii,jj,s+g[ii][jj]);
            visited[ii*m+jj] = false;
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- > 0) {
            w = fs.nextInt();
            words = new HashSet<>();
            found = new TreeSet<>();
            for (int i = 0; i < w; i++) {
                words.add(fs.next());
            }
            n = fs.nextInt();
            m = fs.nextInt();
            g = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    g[i][j] = fs.next().charAt(0);
                }
            }
            visited = new boolean[n*m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i*m+j] = true;
                    dfs(i, j, g[i][j]+"");
                    visited[i*m+j] = false;
                }
            }
            if(found.size()==0){
                System.out.println(-1);
                continue;
            }
            for (String word : found) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
