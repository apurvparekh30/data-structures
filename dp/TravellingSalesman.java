import java.util.*;
import java.io.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static int n;
    static int [][]g;
    static int [][]dp;

    static int rec(int i,int mask){
        if(mask == (1<<n)-1)
            return g[i][0];
        if(dp[i][mask]!=-1)
            return dp[i][mask];
        int ans = 987654321;
        for(int c=0;c<n;c++){
            if((mask & (1<<c))==0){
                ans = Math.min(ans,g[i][c]+rec(c,mask |(1 << c)));
            }
        }
        //System.out.println(i +" " + mask);
        return dp[i][mask] = ans;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc -- > 0){
            n = fs.nextInt();
            g = new int[n][n];
            dp = new int[n][1<<n];
            for(int i=0;i<n;i++)
                Arrays.fill(dp[i],-1);
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    g[i][j] = fs.nextInt();
            System.out.println(rec(0,1));
        }
    }
}