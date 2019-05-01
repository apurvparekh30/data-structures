import java.util.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static char []string;
    static int [][]dp;

    static int rec(int i,int j){
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        if(string[i]==string[j]){
            ans = Math.min(ans,rec(i+1,j-1));
        }
        else {
            ans = Math.min(ans,1 + rec(i+1,j));
            ans = Math.min(ans,1 + rec(i,j-1));
        }
        return dp[i][j] = ans;
    }


    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0) {
            string = fs.next().toCharArray();
            int n = string.length;
            dp = new int[n][n];
            for(int []r:dp){
                Arrays.fill(r,-1);
            }
            System.out.println(rec(0,n-1));
        }
    }
}