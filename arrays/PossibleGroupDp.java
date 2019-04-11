import java.util.*;
import java.io.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static long [][][]dp;
    static int n;
    static int []arr;

    static long rec(int i,int groupSize,int sum){
        if(i >= n){
            if(groupSize == 2 || groupSize == 3){
                if(sum == 0){
                    return 1L;
                }
            }
            return 0L;
        }
        if(dp[i][groupSize][sum]!=-1)
            return dp[i][groupSize][sum];
        long ans = 0;
        ans = rec(i+1,groupSize,sum);
        if(groupSize < 3){
            ans += rec(i+1,groupSize+1,(sum+arr[i])%3);
        }
        return dp[i][groupSize][sum] = ans;
    }

    public static void main(String[] args) {
        int tc =fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = fs.nextInt();
            }
            dp = new long[n][4][3];
            for(int i=0;i<n;i++){
                for(int j=0;j<4;j++){
                    for(int k=0;k<3;k++){
                        dp[i][j][k] = -1;
                    }
                }
            }
            System.out.println(rec(0,0,0));
        }
    }
}