import java.util.*;
import java.io.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static int n;
    static int[] arr;
    static int k;
    static Set<quad> set;
    static Map<Integer, ArrayList<pair>> map;

    static class pair {
        int a, b;

        pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static class quad implements Comparable<quad> {
        int a,b,c,d;
        quad(int a,int b,int c,int d){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(quad o) {
            if(a==o.a){
                if(b==o.b){
                    if(c==o.c){
                        return Integer.compare(d,o.d);
                    }
                    return Integer.compare(c,o.c);
                }
                return Integer.compare(b,o.b);
            }
            return Integer.compare(a, o.a);
        }

        @Override
        public boolean equals(Object obj) {
            quad o = (quad) obj;
            return (this.hashCode()==o.hashCode());
        }
        @Override
        public int hashCode(){
            return (a*b*c*d);
        }
        @Override
        public String toString() {
            return a+" "+b+" "+c+" "+d+" $";
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- > 0) {
            n = fs.nextInt();
            arr = new int[n];
            k = fs.nextInt();
            set = new TreeSet<>();
            map = new HashMap<>();
            for (int i = 0; i < n; i++)
                arr[i] = fs.nextInt();
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int sum = arr[i] + arr[j];
                    ArrayList<pair> al = null;
                    if (map.containsKey(sum)) {
                        al = map.get(sum);
                    } else {
                        al = new ArrayList<>();
                    }
                    al.add(new pair(i, j));
                    map.put(sum, al);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int rem = k - (arr[i] + arr[j]);
                    if (map.containsKey(rem)) {
                        for (pair p : map.get(rem)) {
                            if(p.a!=i && p.a!=j && p.b!=i && p.b!=j)
                                set.add(new quad(arr[i],arr[j],arr[p.a],arr[p.b]));
                        }
                    }
                }
            }
            if(set.size()==0){
                System.out.println("-1");
                continue;
            }
            for(quad q:set){
                System.out.println(q);
            }
            System.out.println();
        }
    }
}
