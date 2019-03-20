import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static char []a,b;
    static int dp[][];
    static int n,m;

    static int rec(int i,int j){
        if(i==n || j==m)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(a[i]==b[j]){
            dp[i][j] = 1 + rec(i+1,j+1);
        }
        else{
            dp[i][j] = Math.max(rec(i+1,j),rec(i,j+1));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            m = fs.nextInt();
            a = fs.next().toCharArray();
            b = fs.next().toCharArray();
            dp = new int[n][m];
            for(int []row:dp){
                Arrays.fill(row,-1);
            }
            System.out.println(rec(0,0));
        }
    }
}