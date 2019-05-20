import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int [][]dp;
    static int []arr;
    static int oo = 987654321;
    static int n,k;

    static int getSum(int i,int j){
        int sum = 0;
        while(i<=j){
            sum = sum + arr[i];
            i++;
        }
        return sum;
    }

    static int rec(int i,int k){
        if(i > n-1)
            return 0;
        if(k==1){
            return getSum(i,n-1);
        }
        if(dp[i][k]!=-1)
            return dp[i][k];
        int ans = oo;
        for(int j = i;j<n;j++){
            int tmp =  Math.max(getSum(i,j),rec(j+1,k-1));
            ans = Math.min(ans,tmp);
        }
        return dp[i][k] = ans;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            k = fs.nextInt();
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = fs.nextInt();
            }
            dp = new int[n][k+1];
            for(int []r:dp){
                Arrays.fill(r,-1);
            }
            System.out.println(rec(0,k));
        }
    }
}