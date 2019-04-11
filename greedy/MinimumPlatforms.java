import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static int []arrival,departure;

    static class Interval implements Comparable<Interval> {
        int u,v;
        Interval(int u,int v){
            this.u = u;
            this.v = v;
        }
        @Override
        public int compareTo(Interval o) {
            if(this.v == o.v)
                return Integer.compare(this.u,o.u);
            return Integer.compare(this.v,o.v);
        }
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arrival = new int[n];
            departure = new int[n];
            for(int i=0;i<n;i++){
                arrival[i] = fs.nextInt();
            }
            for(int i=0;i<n;i++){
                departure[i] = fs.nextInt();
            }
            Interval [] it = new Interval[n];
            for(int i=0;i<n;i++){
                it[i] = new Interval(arrival[i], departure[i]);
            }
            Arrays.sort(it);
            int count = 1;
            int needed = 1;
            int i = 1;
            int j = 0;
            while(i < n && j < n){
                if(it[i].u <= it[j].v){
                    count++;
                    i++;
                    if(needed < count)
                        needed = count;
                }
                else {
                    count--;
                    j++;
                }
            }
            System.out.println(needed);
        }
    }
}