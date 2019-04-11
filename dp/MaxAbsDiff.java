import java.util.*;
import java.io.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static int n;
    static int[] arr;

    static int max(int ii, int jj) {
        int max = Integer.MIN_VALUE;
        int maxTill = 0;
        for (int i = ii; i <= jj; i++) {
            maxTill += arr[i];
            if (max < maxTill) {
                max = maxTill;
            }
            if (maxTill < 0) {
                maxTill = 0;
            }
        }
        return max;
    }

    static int min(int ii, int jj) {
        int min = Integer.MAX_VALUE;
        int minTill = Integer.MAX_VALUE;
        for (int i = ii; i <= jj; i++) {
            if (minTill > 0)
                minTill = arr[i];
            else
                minTill += arr[i];
            if (min > minTill)
                min = minTill;
        }
        return min;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- > 0) {
            n = fs.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            /* int []leftmax,leftmin;
            int []rightmax,rightmin;
            leftmax = new int[n];
            leftmin = new int[n];
            rightmax = new int[n];
            rightmin = new int [n]; */

            int diff = -1;
            for(int i=0;i<n-1;i++){
                int d = Math.abs(min(0,i) - max(i+1,n-1));
                if(d > diff)
                    diff = d;
                d = Math.abs(max(0,i)-min(i+1,n-1));
                if(d > diff)
                    diff = d;
            }

            System.out.println(diff);
        }
    }
}
