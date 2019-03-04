import java.util.*;
import java.io.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static int n;
    static int []dp;

    static int rec(int n){
        //System.out.println(n);
        if(dp[n]!=-1)
            return dp[n];
        int max = 0;
        for(int i=1;i<=n-3;i++){
            int curr = rec(i) * (n-i-1);
            if(max < curr)
                max = curr;
        }
        return dp[n] = max;
    }

    public static void main(String[] args) {
        dp = new int[76];
        Arrays.fill(dp,-1);
        for(int i=0;i<=6;i++)
            dp[i] = i;
        int tc = fs.nextInt();
        while(tc-- > 0){
            int n = fs.nextInt();
            if(n > 75)
                System.out.println("-1");
            else
                System.out.println(rec(n));
        }
    }

}