// GeeksforGeeks trapping rain water solution

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static FastReader scan = new FastReader();
    static int n;
    static int []arr;
    static int []left;
    static int []right;
	public static void main (String[] args) {
        //code
        int cases = scan.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = scan.nextInt();
            arr = new int[n];
            left = new int[n];
            right = new int[n];
            
            for(int i=0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            //System.out.println(Arrays.toString(arr));
            for(int i=1;i<n-1;i++){
                left[i] = Math.max(arr[i-1],left[i-1]);
            }
            for(int i=n-2;i>0;i--){
                right[i] = Math.max(arr[i+1],right[i+1]);
            }
            //System.out.println(Arrays.toString(left));
            //System.out.println(Arrays.toString(right));
            int water = 0;
            for(int i=1;i<n-1;i++){
                int tmp;
                tmp = Math.min(left[i],right[i]);
                water += Math.max(0,tmp-arr[i]);
            }
            System.out.println(water);
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