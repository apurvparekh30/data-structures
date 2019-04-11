import java.util.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int [][]memo;
    static int n;
    static int []arr;
    static int total;

    static int dp(int i,int sum){
        if(i==n){
            //System.out.println(sum);
            return Math.abs(sum - (total-sum));
        }
        if(memo[i][sum]!=-1){
            return memo[i][sum];
        }
        memo[i][sum] = 0;
        return memo[i][sum] = Math.min(dp(i+1,sum),dp(i+1,sum+arr[i]));
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arr = new int[n];
            total = 0;
            for(int i=0;i<n;i++){
                arr[i] = fs.nextInt();
                total = total + arr[i];
            }
            memo = new int[n][total+1];
            for(int i=0;i<n;i++){
                Arrays.fill(memo[i],-1);
            }
            System.out.println(dp(0,0));
        }
    }
}