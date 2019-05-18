import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    
    static class Interval implements Comparable<Interval> {
        int s,t,i;
        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.t, o.t);
        }
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            int n = fs.nextInt();
            Interval []interval = new Interval[n];
            
            for(int i=0;i<n;i++){
                interval[i] = new Interval();
                interval[i].s = fs.nextInt();
                interval[i].i = i + 1;
            }
            for(int i=0;i<n;i++){
                interval[i].t = fs.nextInt();
            }
            Arrays.sort(interval);
            List<Interval> meetings = new ArrayList<>();
            int currEnd = interval[0].t;
            meetings.add(interval[0]);
            int i = 1;
            while(i < n){
                if(interval[i].s > currEnd){
                    meetings.add(interval[i]);
                    currEnd = interval[i].t;
                }
                i++;
            }
            StringBuilder sb = new StringBuilder();
            for(Interval meeting:meetings){
                sb.append(meeting.i).append(' ');
            }
            System.out.println(sb);
        }
    }
}