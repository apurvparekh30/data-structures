import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static int []arr;
    static int dp [][];

    static int rec(int i,int j){
        if(j-i==1){
            return Math.max(arr[i],arr[j]);
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        dp[i][j] = 0;
        int a = arr[i] + Math.min(rec(i+1,j-1),rec(i+2,j));
        int b = arr[j] + Math.min(rec(i,j-2),rec(i+1,j-1));
        dp[i][j] = Math.max(a,b);
        return dp[i][j];
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            dp = new int[n][n];
            for(int []row:dp){
                Arrays.fill(row,-1);
            }
            System.out.println(rec(0,n-1));
        }
    }
}