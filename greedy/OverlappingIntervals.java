import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    
    static class interval implements Comparable<interval> {
        int s,t;
        interval(int s,int t){
            this.s = s;
            this.t = t;
        }
        @Override
        public int compareTo(interval o) {
            return Integer.compare(this.s,o.s);
        }
        @Override
        public String toString() {
            return s + " " + t;
        }
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            interval []arr = new interval[n];
            for(int i=0;i<n;i++){
                arr[i] = new interval(fs.nextInt(),fs.nextInt());
            }
            Arrays.sort(arr);
            int j = 0;
            List<interval> list = new ArrayList<>(); 
            while(j < n){
                int x = arr[j].s;
                int y = arr[j].t;
                int i = j+1;
                while(i < n && arr[i].s <= y){
                    y = Math.max(arr[i].t,y);
                    i++;
                }
                list.add(new interval(x,y));
                j = i;
            }
            for(interval inter:list){
                System.out.print(inter + " ");
            }
            System.out.println();
        }
    }
}