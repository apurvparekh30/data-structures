
// Solution to Maxinum Index

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static int n;
    static int []arr;
    static int []maxIndex;
    static FastReader fs = new FastReader();

    public static void main(String[] args) {
        // code
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            arr = new int[n];
            maxIndex = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            maxIndex[n-1] = n - 1;
            for(int i=n-1;i>0;i--)
                maxIndex[i-1] = arr[i-1] > arr[maxIndex[i]] ? i - 1:maxIndex[i];
            int i = 0;
            int j = 0;
            int max = 0;
            while(i < n && j < n){
                if(arr[i] <= arr[maxIndex[j]]){
                    max = (j - i > max) ? j - i : max;
                    j++;
                }
                else 
                    i++;
            }
            System.out.println(max);
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
    
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}