import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static Set<Integer> a,b;
    static Deque<Integer> dq;
    static TreeSet<Integer> set;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            a = new HashSet<>();
            b = new HashSet<>();
            dq = new ArrayDeque<>();
            set = new TreeSet<>(Comparator.reverseOrder());
            for(int i=0;i<n;i++){
                int no = fs.nextInt();
                a.add(no);
                set.add(no);
            }
            for(int i=0;i<n;i++){
                int no = fs.nextInt();
                b.add(no);
                set.add(no);
            }
            for(int i=0;i<n;i++){
                int no = set.pollFirst();
                if(b.contains(no)){
                    dq.addFirst(no);
                }
                else {
                    dq.addLast(no);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(dq.pollFirst()).append(' ');
            }
            System.out.println(sb);
        }
    }
}