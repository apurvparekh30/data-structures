import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static char []a,b;
    static int [][]dp;

    static int rec(int i,int j){
        if(i>=a.length || j>=b.length)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        rec(i+1,j);
        rec(i,j+1);

        if(a[i]==b[j]){
            return dp[i][j] = 1 + rec(i+1,j+1);
        }
        return dp[i][j] = 0;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            int n = fs.nextInt();
            int m = fs.nextInt();
            a = fs.next().toCharArray();
            b = fs.next().toCharArray();
            dp = new int[n][m];
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i],-1);
            }
            rec(0,0);
            int max = 0;
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++)
                    max = Math.max(max,dp[i][j]);
            System.out.println(max);
        }
    }   
}