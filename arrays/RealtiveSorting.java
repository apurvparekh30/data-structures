// geeksforgeeks relative sorting

import java.util.*;
import java.io.*;

class Solution{

    static FastReader fs = new FastReader();
    static int n,m;
    static Integer []arr;
    static Map<Integer,Integer> hm;

    static class IntComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a,Integer b){
            boolean aa = hm.containsKey(a);
            boolean bb = hm.containsKey(b);
            if(!aa && !bb){
                return Integer.compare(a, b);
            }
            if(aa && bb){
                return Integer.compare(hm.get(a),hm.get(b));
            }
            if(!aa && bb){
                return 1;
            }
            return -1;
        }
    }

    /* static int getItself(int itself,int dummy){
        return itself;
    }
    static int partition(int s,int t){
        int i = s - 1;
        int j = s;
        int p = arr[t];
        for(;j<t;j++){
            if(!hm.containsKey(p) && !hm.containsKey(arr[j])){
                if(arr[j] < p){
                    i += 1;
                    arr[j] = getItself(arr[i],arr[i] = arr[j]);
                }
            }
            else if(hm.containsKey(p) && hm.containsKey(arr[j])){
                if(hm.get(arr[j]) < hm.get(p)){
                    i += 1;
                    arr[j] = getItself(arr[i],arr[i] = arr[j]);
                }
            }
            else if(!hm.containsKey(p)){
                i += 1;
                arr[j] = getItself(arr[i],arr[i] = arr[j]);
            }
        }
        arr[i+1] = getItself(arr[t],arr[t] = arr[i+1]);
        return i+1;
    }

    static void qsort(int s,int t){
        if(s < t){
            int p = partition(s, t);
            qsort(s,p-1);
            qsort(p+1,t);
        }
    } */
    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            m = fs.nextInt();
            arr = new Integer[n];
            hm = new HashMap<>();
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            for(int i=0;i<m;i++){
                hm.put(fs.nextInt(),i);
            }
            Arrays.sort(arr,new IntComparator());
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
            
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