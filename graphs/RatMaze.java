import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();
            GfG g = new GfG();
            ArrayList<String> res = g.printPath(a, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}

class GfG {
    static ArrayList<String> paths;
    static boolean done[][];
    static int []dr = {1,0,0,-1};
    static int []dc = {0,-1,1,0};
    static String []dir = {"D","L","R","U"};

    static void dfs(int i,int j,String path,int [][]m,int n){
        if(i==n-1 && j==n-1){
            paths.add(path);
            return;
        }
        for(int k=0;k<4;k++){
            int ni = i + dr[k];
            int nj = j + dc[k];
            if(ni<0 || ni>=n || nj<0 || nj >=n)
                continue;
            if(done[ni][nj])
                continue;
            if(m[ni][nj]==0)
                continue;
            done[ni][nj] = true;
            dfs(ni,nj,path+dir[k],m,n);
            done[ni][nj] = false;
        }
    }

    public static ArrayList<String> printPath(int[][] m, int n) {
        // Your code here
        paths = new ArrayList<>();
        done = new boolean[n][n];
        done[0][0] = true;
        dfs(0,0,"",m,n);
        Collections.sort(paths);
        return paths;
    }
}