import java.util.*;
import java.lang.Math;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            GfG g = new GfG();
            System.out.println(g.maxCoins(a, n));

        }
    }
}

class GfG {

    static int memo[][];

    static int rec(int i, int j, int []arr) {
        if(i==j)
            return arr[i];
        if(j - i == 1)
            return Math.max(arr[i],arr[j]);
        if(memo[i][j]!=-1)
            return memo[i][j];
        memo[i][j] = 0;
        int left = arr[i] + Math.min(rec(i+2,j,arr),rec(i+1,j-1,arr));
        int right = arr[j] + Math.min(rec(i,j-2,arr),rec(i+1,j-1,arr));
        return memo[i][j] = Math.max(left,right);   
    }

    public static int maxCoins(int A[], int n) {
        memo = new int[A.length][A.length];
        for(int i=0;i<A.length;i++)
            Arrays.fill(memo[i],-1);
        return rec(0,A.length-1,A);
    }
}
