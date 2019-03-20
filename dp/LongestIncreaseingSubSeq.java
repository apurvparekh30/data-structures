import java.util.*;

class Solution {
    
    static Scanner fs = new Scanner(System.in);
    static int arr[];
    static int []dp;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            int n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            int max = 0;
            dp = new int[n];
            dp[0] = 1;
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(arr[j] < arr[i])
                        dp[i] = Math.max(dp[j],dp[i]);
                }
                dp[i] = dp[i] + 1;
                max = Math.max(dp[i],max);
            }
            System.out.println(max);
        }
    }   
}