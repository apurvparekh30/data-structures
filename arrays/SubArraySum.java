import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static int n;
    static long []arr;
    static int k;
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            k = fs.nextInt();
            arr = new long[n+1];
            for(int i=1;i<=n;i++){
                arr[i] = arr[i-1] + fs.nextInt();
            }
            int a = 0, b=0;
            boolean flag = false;
            for(int i=0;i<=n;i++){
                if(arr[i] >= k){
                    for(int j=i-1;j>=0;j--){
                        long sum = arr[i] - arr[j];
                        if(sum == k){
                            a = j+1;
                            b = i;
                            flag = true;
                        }
                        if(sum > k)
                            break;
                    }
                }
                if(flag)
                    break;
            }
            if(flag)
                System.out.println(a + " " + b);
            else
                System.out.println("-1");
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