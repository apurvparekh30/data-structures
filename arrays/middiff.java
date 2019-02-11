
// solution to minimum difference pair in java

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        // code
        Scanner fs = new Scanner(System.in);
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            int n = fs.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            for(int i=1;i<n;i++){
                min = Math.min(min,arr[i]-arr[i-1]);
            }
            System.out.println(min);
        }
    }
}